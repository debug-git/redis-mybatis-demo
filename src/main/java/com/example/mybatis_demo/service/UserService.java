package com.example.mybatis_demo.service;

import com.example.mybatis_demo.pojo.User;

import java.util.List;

public interface UserService {
    List<User> selectUserPage(int id);

    Integer updatePojo(User user);

    Integer deleteUser(int id);
}
