package com.example.mybatis_demo.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class User implements Serializable {
    private Integer userId;
    private String userName;
    private String password;
    private String phone;
    private Date modifyTime;
    private static Map map = new HashMap();


//    public User(Integer userId, String userName, String password, String phone, String state) {
//        this.userId = userId;
//        this.userName = userName;
//        this.password = password;
//        this.phone = phone;
//    }

//    public User() {
//        System.out.println("默认构造方法");
//    }


    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", modifyTime=" + modifyTime +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public static Map getMap() {
        return map;
    }

    public static void setMap(Map map) {
        User.map = map;
    }
}
