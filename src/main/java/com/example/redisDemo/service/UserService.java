package com.example.redisDemo.service;

import com.example.redisDemo.pojo.User;

import java.util.List;

public interface UserService {
    List<User> selectUserPage(int id);

    Integer updatePojo(User user);

    Integer deleteUser(int id);
}
