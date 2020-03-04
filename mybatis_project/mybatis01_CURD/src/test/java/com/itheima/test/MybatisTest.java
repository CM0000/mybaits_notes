package com.itheima.test;

import com.itheima.dao.UserMapper;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    @Test
    public void findAll() throws Exception {
        //1.读取配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.根据配置文件构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //3.创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //4.使用SqlSession对象操作数据库
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.findAll();
        //5.关闭sqlSession
        for (User user : users) {
            System.out.println(user);
        }
    }
}
