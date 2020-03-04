package com.itheima.dao;

import com.itheima.domain.User;

import java.util.List;

public interface UserMapper {
    //1. 查询用户
    List<User> findAll();

    //2. 查询用户-id
    User findById(Integer id);

    //3. 查询用户-username模糊查询
    List<User> findByUsername(String username);
    //4. 添加用户
    Integer save(User user);
    //5. 更新用户
    Integer update(User user);
    //6. 删除用户
    Integer delete(Integer id);
}
