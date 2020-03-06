package com.itheima.test;

import com.itheima.domain.User;
import com.itheima.util.MyBatisUtil;
import jdk.internal.util.xml.impl.Input;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {
    @Test
    public void findByUsernameAndAddress01() throws Exception {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        User user = new User();
        user.setUsername("王");
        user.setAddress("北京金燕龙");
        List<User> users = sqlSession.selectList("com.itheima.mapper.UserMapper.findByUsernameAndAddress01", user);
        for (User user1 : users) {
            System.out.println(user1);
        }
        //关闭sqlSession
        sqlSession.close();
    }
    @Test
    public void findByUsernameAndAddress02() throws Exception {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        User user = new User();
        user.setAddress("北京金燕龙");
        List<User> users = sqlSession.selectList("com.itheima.mapper.UserMapper.findByUsernameAndAddress02", user);
        for (User user1 : users) {
            System.out.println(user1);
        }
        //关闭sqlSession
        sqlSession.close();
    }
    @Test
    public void findByUsernameAndAddress03() throws Exception {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        User user = new User();
        user.setUsername("王");
        user.setAddress("北京金燕龙");
        List<User> users = sqlSession.selectList("com.itheima.mapper.UserMapper.findByUsernameAndAddress03", user);
        for (User user1 : users) {
            System.out.println(user1);
        }
        //关闭sqlSession
        sqlSession.close();
    }
    @Test
    public void findByUsernameAndAddress04() throws Exception {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        User user = new User();
        user.setAddress("北京金燕龙");
        List<User> users = sqlSession.selectList("com.itheima.mapper.UserMapper.findByUsernameAndAddress04", user);
        for (User user1 : users) {
            System.out.println(user1);
        }
        //关闭sqlSession
        sqlSession.close();
    }@Test
    public void findByUsernameAndAddress05() throws Exception {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        User user = new User();
        user.setUsername("王");
        List<User> users = sqlSession.selectList("com.itheima.mapper.UserMapper.findByUsernameAndAddress05", user);
        for (User user1 : users) {
            System.out.println(user1);
        }
        //关闭sqlSession
        sqlSession.close();
    }
    @Test
    public void findByUsernameAndAddress07() throws Exception {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        User user = new User();
        user.setId(50);
        user.setAddress("北京金燕龙");
        List<User> users = sqlSession.selectList("com.itheima.mapper.UserMapper.findByUsernameAndAddress07", user);
        for (User user1 : users) {
            System.out.println(user1);
        }
        //关闭sqlSession
        sqlSession.close();
    }

}
