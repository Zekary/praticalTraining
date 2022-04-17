package com.gec.service.impl;

import com.gec.bean.User;
import com.gec.bean.UserExample;
import com.gec.mapper.UserMapper;
import com.gec.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//业务层的实现类

//标示为业务层的代码
@Service
public class UserServiceImpl implements UserService{

    //IOC中获取UserMapper的对象
    @Autowired
    UserMapper userMapper;

    @Override
    public User login(String name, String pass) {
        //1.创建模版对象
        UserExample example = new UserExample();
        //2.添加查询条件
        example.createCriteria().andUsernameEqualTo(name).andPasswordEqualTo(pass);
        //3.执行查询
        List<User> list = userMapper.selectByExample(example);

        //集合不为空
        if(list!=null&&list.size()>0&&!list.isEmpty()){
            return list.get(0);
        }
        else
            return null;
    }

    @Override
    public boolean register(User user){
        return userMapper.insertSelective(user)>0 ? true:false;
    }

    @Override
    public List<User> query() {
        return userMapper.selectByExample(new UserExample());
    }

    @Override
    public User queryId(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean updateUser(User user) {
        return userMapper.updateByPrimaryKeySelective(user)>0 ? true:false;
    }

    @Override
    public boolean delete(int id) {
        return userMapper.deleteByPrimaryKey(id)>0 ? true:false;
    }
}
