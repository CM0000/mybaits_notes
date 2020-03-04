package com.itheima.test;

import com.itheima.dao.UserMapper;
import com.itheima.domain.User;
import jdk.nashorn.internal.ir.CallNode;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
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
        sqlSession.close();
        for (User user : users) {
            System.out.println(user);
        }

    }
    @Test
    public void findById() throws Exception {
        //1.读取配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.根据配置文件构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //3.创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //4.使用SqlSession对象操作数据库
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.findById(46);
        System.out.println(user);
        //5.关闭sqlSession
        sqlSession.close();

    }@Test
    public void findByUsername() throws Exception {
        //1.读取配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.根据配置文件构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //3.创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //4.使用SqlSession对象操作数据库
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.findByUsername("王");
        for (User user : users) {
            System.out.println(user);
        }
        //5.关闭sqlSession
        sqlSession.close();

    }@Test
    public void save() throws Exception {
        //1.读取配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.根据配置文件构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //3.创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //4.使用SqlSession对象操作数据库
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("吕布");
        user.setBrithday(new Date());
        user.setSex("男");
        user.setAddress("淮西");
        Integer count = userMapper.save(user);
        if(count>0){
            System.out.println("保存成功！");
        }else{
            System.out.println("保存失败！");
        }

        sqlSession.commit();
        //5.关闭sqlSession
        sqlSession.close();

    }
    @Test
    public void update() throws Exception {
        //1.读取配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.根据配置文件构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //3.创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //4.使用SqlSession对象操作数据库
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(43);
        user.setUsername("貂蝉");
        user.setBrithday(new Date());
        user.setSex("女");
        user.setAddress("王允府上");
        Integer count = userMapper.update(user);
        if(count>0){
            System.out.println("更新成功！");
        }else{
            System.out.println("更新失败！");
        }
        sqlSession.commit();
        //5.关闭sqlSession
        sqlSession.close();

    }
    @Test
    public void delete() throws Exception {
        //1.读取配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.根据配置文件构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //3.创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //4.使用SqlSession对象操作数据库
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Integer count = userMapper.delete(46);
        if(count>0){
            System.out.println("删除成功！");
        }else{
            System.out.println("删除失败！");
        }
        sqlSession.commit();

        //5.关闭sqlSession
        sqlSession.close();

    }
}
