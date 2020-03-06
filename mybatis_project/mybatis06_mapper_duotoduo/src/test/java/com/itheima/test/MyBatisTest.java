package com.itheima.test;


import com.itheima.domain.Banji;
import com.itheima.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyBatisTest {
    @Test
    public void findByUsernameAndAddress01() throws Exception {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        Banji banji = sqlSession.selectOne("com.itheima.mapper.BanjiMapper.findBanjiById", 1);
        System.out.println(banji);

        //关闭sqlSession
        sqlSession.close();
    }


}
