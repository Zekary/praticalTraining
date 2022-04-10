package com.gec.controler;

import com.gec.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//标志注解，用于标明当前类是控制的代码，交给ioc容器管理的
@Controller
public class UserControler {
    //http://localhost:8080/springmvcDemo/login?name=addmin&password=123456
    //定义请求处理的方法【登录请求处理】【方法】
//    @RequestMapping("/login")
//    @ResponseBody  //意思：直接返回数据，输出到页面中，不跳转页面
//    public String login(String name, String password) {
//        //
//        if (name.equals("admin") && password.equals("123456")) {
//            return "login success!";
//        } else {
//            return "login failed!";
//        }
//    }
/*以上是无页面跳转的，直接在本页面返回结果*/

//以下是有页面跳转的写法
//    @RequestMapping("/login")
//    public String login(String name, String password) {
//        //
//        if (name.equals("admin") && password.equals("123456")) {
////            return "index"; 这里如果不改最后会返回 /index.jsp，但是定义的是html文件，所以需要重定向
//            return "redirect:/index.html";
//        } else {
//            return "login"; //springmvc.xml的视图解析器会补全路径为 /login.jsp
//        }
//    }


    //以下是有页面跳转的写法，而且springmvc对提交的数据进行封装处理,请求提交的key要和实体类成员的变量名一致
    @RequestMapping("/login")
    public String login(User user) {
        if (user.getName().equals("admin") && user.getPassword().equals("123456")) {
            return "redirect:/index.html";
        } else {
            return "login"; //springmvc.xml的视图解析器会补全路径为 /login.jsp
        }
    }
}
