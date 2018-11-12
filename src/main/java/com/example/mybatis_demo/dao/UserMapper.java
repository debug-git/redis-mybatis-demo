package com.example.mybatis_demo.dao;


import com.example.mybatis_demo.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface UserMapper{

    List<User> selectUserList();

    Integer insertBatch();

    Integer update(User user);

    Integer insertList(@Param(value = "kkk")List<User> list);

    Integer deleteUser(int id);
}
