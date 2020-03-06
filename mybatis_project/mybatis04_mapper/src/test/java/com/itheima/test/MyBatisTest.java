package com.itheima.test;


import com.itheima.domain.Student;
import com.itheima.domain.StudentIdCard;
import com.itheima.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyBatisTest {
    @Test
    public void findByUsernameAndAddress01() throws Exception {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        Student student = sqlSession.selectOne("com.itheima.mapper.StudentMapper.findStudentById", 1);
        System.out.println(student);

        //关闭sqlSession
        sqlSession.close();
    }


}
