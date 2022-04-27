package com.gec.controller;


import com.gec.bean.Bank;
import com.gec.bean.Bankcard;
import com.gec.service.BankCardService;
import com.gec.service.BankService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

//使用控制层标识的代码
@Controller
public class BankCardController {

    //获取业务层的操作对象
    @Autowired
    BankCardService bankCardService;
    @Autowired
    BankService bankService;
    
    //定义添加的方法
    @RequestMapping("/toInsertBankCard")
    public String toInsertBank(HttpServletRequest request){
        //调用业务层进行添加
        List<Bank> banks = bankService.query();
        //保存银行数据到添加页面
        request.setAttribute("banks",banks);
        return "BankCardInsert";
    }

    //定义查询操作的请求方法
    @RequestMapping("/queryBankCard")
//  @ResponseBody 在本页面观察是否可以查询到值
    public String queryBankCard(@RequestParam(required = false,defaultValue = "1") Integer pageNo,HttpServletRequest request){
        //开启分页操作 当前页码  每页显示记录数
        //处理page=0的bug
        if(pageNo==0)
            pageNo=1;
        PageHelper.startPage(pageNo,3);

        List<Bankcard> list = bankCardService.query();

        //生成page分页的模型信息
        PageInfo pageInfo = new PageInfo(list);

        request.setAttribute("list",list);
        request.setAttribute("pageInfo",pageInfo );
//      return list;
        //跳转到jsp页面获取并显示
        return "BankCardList";
    }

    //定义修改操作的请求方法
    @RequestMapping("/toUpdateBankCard")
    public String toUpadteBank(Integer id, HttpServletRequest request){
        Bankcard updateBankCard = bankCardService.queryId(id);
        request.setAttribute("updateBankCard",updateBankCard);

        List<Bank> banks = bankService.query();
        //保存银行数据到添加页面
        request.setAttribute("banks",banks);
        return "BankCardUpdate";
    }

    @RequestMapping("/updateBankCard")
    public String updateBank(Bankcard bankcard,HttpServletRequest request){
        boolean isok = bankCardService.updateBankcard(bankcard);
        if (isok){
            //修改成功则重新查询数据
            return "redirect:/queryBankCard";
        }
        else{
            request.setAttribute("bankcard",bankcard);
            request.setAttribute("message","修改失败，请重新操作");
            return "BankCardUpdate";
        }
    }

    //定义删除银行数据的方法
    @RequestMapping("/deleteBankCard")
    public String delete(int id,HttpServletRequest request){
        bankCardService.delete(id);
        //作出响应
        return "redirect:/queryBankCard";
    }


}
