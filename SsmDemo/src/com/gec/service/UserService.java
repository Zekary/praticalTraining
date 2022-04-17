package com.gec.service;

import com.gec.bean.User;

import java.util.List;

//业务层及抽象接口及方法定义
public interface UserService {
    //用户的登录功能
    public User login(String name,String pass);

    //用户登录功能
    public boolean register(User user);

    //用户列表查询
    public List<User> query();

    //根据id进行用户查询
    public User queryId(int id);

    //用户根据id进行修改功能
    public boolean updateUser(User user);

    //用户根据id删除用户数据
    public boolean delete(int id);
}
