package com.gec.controller;


import com.gec.bean.Bank;
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
public class BankController {

    //获取业务层的操作对象
    @Autowired
    BankService bankService;
    
    //定义添加的方法
    @RequestMapping("/insertBank")
    public String insertBank(Bank bank,HttpServletRequest request){
        //调用业务层进行添加
        boolean isok = bankService.insert(bank);
        //作出响应
        if(isok)
            return "redirect:/queryBank";
        else
        {
            //保存插入的银行信息
            request.setAttribute("bank",bank);
            request.setAttribute("message","添加失败，请重新操作。");
            return "BankInsert";
        }
    }

    //定义查询操作的请求方法
    @RequestMapping("/queryBank")
//  @ResponseBody 在本页面观察是否可以查询到值
    public String queryBank(@RequestParam(required = false,defaultValue = "1") Integer pageNo,HttpServletRequest request){
        //开启分页操作 当前页码  每页显示记录数
        //处理page=0的bug
        if(pageNo==0)
            pageNo=1;
        PageHelper.startPage(pageNo,3);

        List<Bank> list = bankService.query();

        //生成page分页的模型信息
        PageInfo pageInfo = new PageInfo(list);

        request.setAttribute("list",list);
        request.setAttribute("pageInfo",pageInfo );
//      return list;
        //跳转到jsp页面获取并显示
        return "BankList";
    }

    //定义修改操作的请求方法
    @RequestMapping("/toUpdateBank")
    public String toUpadteBank(Integer id, HttpServletRequest request){
        Bank updateBank = bankService.queryId(id);
        request.setAttribute("updateBank",updateBank);
        return "BankUpdate";
    }

    @RequestMapping("/updateBank")
    public String updateBank(Bank bank,HttpServletRequest request){
        boolean isok = bankService.updateBank(bank);
        if (isok){
            //修改成功则重新查询数据
            return "redirect:/queryBank";
        }
        else{
            request.setAttribute("bank",bank);
            request.setAttribute("message","修改失败，请重新操作");
            return "BankUpdate";
        }
    }

    //定义删除银行数据的方法
    @RequestMapping("/deleteBank")
    public String delete(int id,HttpServletRequest request){
        bankService.delete(id);
        //作出响应
        return "redirect:/queryBank";
    }


}
