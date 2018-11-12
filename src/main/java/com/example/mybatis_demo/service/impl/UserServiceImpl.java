package com.example.mybatis_demo.service.impl;

import com.example.mybatis_demo.dao.UserMapper;
import com.example.mybatis_demo.pojo.User;
import com.example.mybatis_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;


@Service
@CacheConfig(cacheNames = "user")
public class UserServiceImpl implements UserService {

   @Autowired
   UserMapper userMapper;

    @Override
    @Cacheable(key = "#p0")
//  @Cacheable标注的方法会在调用后被Spring将其返回值缓存起来，以保证下次利用同样的参数，
//  来执行该方法时可以直接从缓存中获取结果，而不需要再次执行该方法
    public List<User> selectUserPage(int id) {
        System.out.println("没有使用缓存,id="+id);
        return userMapper.selectUserList();
    }

    @Override
    @CachePut(key = "#user.userId")
//  @CachePut标注的方法在执行前不会去检查缓存中是否存在之前执行过的结果,
//  而是每次都会执行该方法，并将执行结果以键值对的形式存入指定的缓存中。
    public Integer updatePojo(User user) {
        System.out.println("更新缓存");
        System.out.println("添加一行");
        System.out.println("再添加一行");
        return userMapper.update(user);
    }

    @Override
    @CacheEvict(key = "#id",beforeInvocation = true)
//    beforeInvocation代表在该方法执行前删除缓存,避免因方法内出现异常而没有删除缓存
    public Integer deleteUser(int id) {
        System.out.println("删除缓存");
        return userMapper.deleteUser(id);
    }

}
