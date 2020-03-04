package com.itheima.test;

import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

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
        List<Object> users = sqlSession.selectList("com.itheima.mapper.UserMapper.findAll");

        //5.关闭sqlSession
        sqlSession.close();
        for (Object user : users) {
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
        User user = sqlSession.selectOne("com.itheima.mapper.UserMapper.findById", 42);
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
        List<User> users = sqlSession.selectList("com.itheima.mapper.UserMapper.findByUsername", "王");
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

        User user = new User();
        user.setUsername("诸葛亮");
        user.setBrithday(new Date());
        user.setSex("男");
        user.setAddress("陇西");
        Integer count = sqlSession.insert("com.itheima.mapper.UserMapper.save", user);
        if(count>0){
            System.out.println("插入成功！");
        }else{
            System.out.println("插入失败！");
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

        User user = new User();
        user.setId(43);
        user.setUsername("貂蝉");
        user.setBrithday(new Date());
        user.setSex("女");
        user.setAddress("王允府上");
        int count = sqlSession.update("com.itheima.mapper.UserMapper.update", user);
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
        int count = sqlSession.delete("com.itheima.mapper.UserMapper.delete", 41);
        if(count>0){
            System.out.println("删除成功！");
        }else{
            System.out.println("删除失败！");
        }/*
        sqlSession.commit();*/

        //5.关闭sqlSession
        sqlSession.close();

    }
}
