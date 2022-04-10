package com.gec.test;

import com.gec.bean.User;
import com.gec.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException {
        //1、加载mybatis的全局配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //2、生成sqlsessionfactory【会话的工厂类】【用于生成session会话】
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        //3、通过sqlsessionfactory来得到生成sqlsession会话对象
        SqlSession session = sqlSessionFactory.openSession();
        //4、通过会话对象得到mapper接口对象
        UserMapper userMapper = session.getMapper(UserMapper.class);
        //通过mapper对象执行操作方法

//插入操作(增)
//        User user = new User();
//        user.setUsername("Tom");
//        user.setPassword("123456");
//        int result = userMapper.insertUser(user);
//        System.out.println(result);


//修改操作（改）
//        User user = new User();
//        user.setId(2);
//        user.setUsername("zhangsan");
//        user.setPassword("abc");
//        int result = userMapper.updateUser(user);
//        System.out.println(result);
//        //添加删除修改要提交事务
//        session.commit();


//  删除数据（删）
//        int result = userMapper.deleteUser(2);
//        System.out.println(result);
//        //添加删除修改要提交事务
//        session.commit();

//查询数据（查）
        List<User> list = userMapper.selectUser();
        for (User u : list){
            System.out.println(u);
        }
        session.commit();
    }
}
