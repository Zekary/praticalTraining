package com.gec.mapper;

import com.gec.bean.User;

import java.util.List;

//UserMapper 用于绑定关联xml文件中的SQL语句
public interface UserMapper {

    //关联了xml中方法名对应的sql操作语句
    public int insertUser(User user);

    public int updateUser(User user);

    public int deleteUser(int id);

    public List<User> selectUser();
}
