package com.gec.controller;


import com.gec.bean.User;
import com.gec.service.UserService;
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
public class UserController {

    //获取业务层的操作对象
    @Autowired
    UserService userService;


    //定义登录操作的请求方法
    @RequestMapping("/login")
    public String login(String name, String password, HttpServletRequest request){
        //调用业务层进行登录校验
        User nowuser = userService.login(name,password);
        //作出响应
        if (nowuser!=null){
            return "index";
        }
        else {
            //把信息保存在请求作用域中，目的给jsp页面获取并显示
            request.setAttribute("name",name);
            request.setAttribute("password",password);
            request.setAttribute("message","用户名或密码错误");
            return "login";
        }
    }

    //定义注册操作的请求方法
    @RequestMapping("/register")
    public String register(User user,HttpServletRequest request){
        //调用业务层进行添加
        boolean isok = userService.register(user);
        //作出响应
        if(isok)
            return "login";
        else
        {
            //把注册信息保存在session域里面
            request.setAttribute("user",user);
            request.setAttribute("message","注册失败，请重新操作");
            return "regester";
        }
    }

    //定义查询操作的请求方法
    @RequestMapping("/query")
//  @ResponseBody 在本页面观察是否可以查询到值
    public String query(@RequestParam(required = false,defaultValue = "1") Integer pageNo,HttpServletRequest request){
        //开启分页操作 当前页码  每页显示记录数
        //处理page=0的bug
        if(pageNo==0)
            pageNo=1;
        PageHelper.startPage(pageNo,3);

        List<User> list = userService.query();

        //生成page分页的模型信息
        PageInfo pageInfo = new PageInfo(list);

        request.setAttribute("list",list);
        request.setAttribute("pageInfo",pageInfo );
//      return list;
        //跳转到jsp页面获取并显示
        return "UserList";
    }

    //定义修改操作的请求方法
    @RequestMapping("/toUpdateUser")
    public String toUpadteUser(Integer id, HttpServletRequest request){
        User updateUser = userService.queryId(id);
        request.setAttribute("updateUser",updateUser);
        return "UserUpdate";
    }

    @RequestMapping("/updateUser")
    public String updateUser(User user,HttpServletRequest request){
        boolean isok = userService.updateUser(user);
        if (isok){
            //修改成功则重新查询数据
            return "redirect:/query";
        }
        else{
            request.setAttribute("user",user);
            request.setAttribute("message","修改失败，请重新操作");
            return "UserUpdate";
        }
    }

    //定义删除用户数据的方法
    @RequestMapping("/deleteUser")
    public String delete(int id,HttpServletRequest request){
        userService.delete(id);
        //作出响应
        return "redirect:/query";
    }


}
