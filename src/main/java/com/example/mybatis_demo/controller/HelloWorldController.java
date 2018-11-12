package com.example.mybatis_demo.controller;

import com.example.mybatis_demo.dao.UserMapper;
import com.example.mybatis_demo.pojo.User;
import com.example.mybatis_demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * code is far away from bug with the animal protecting
 * ┏┓　　　┏┓
 * ┏┛┻━━━┛┻┓
 * ┃　　　　　　　┃
 * ┃　　　━　　　┃
 * ┃　┳┛　┗┳　┃
 * ┃　　　　　　　┃
 * ┃　　　┻　　　┃
 * ┃　　　　　　　┃
 * ┗━┓　　　┏━┛
 * 　　┃　　　┃神兽保佑
 * 　　┃　　　┃代码无BUG！
 * 　　┃　　　┗━━━┓
 * 　　┃　　　　　　　┣┓
 * 　　┃　　　　　　　┏┛
 * 　　┗┓┓┏━┳┓┏┛
 * 　　　┃┫┫　┃┫┫
 * 　　　┗┻┛　┗┻┛
 *
 * ---------------------------------
 */

@RestController
//@Controller
public class HelloWorldController {
    private static final Logger logger = LoggerFactory.getLogger(HelloWorldController.class);
    @Value("${content}")
    private String content;

    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/hello")
    public String index() {
//        Map map = User.getMap();
//        System.out.println(map.get("1"));
        return "Hello World!content:"+content;
    }

    @RequestMapping("/get")
    public Object selectPage(Model model){
        List f = userService.selectUserPage(1);
        System.out.println("返回"+f.size()+"条记录");
        return f;
    }

    @RequestMapping("insert")
    @Transactional(propagation= Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer insertBatch() {
        Integer i = userMapper.insertBatch();
        logger.info("插入影响{}条数据",i);
        try {
            throw new Exception("故意抛异常");
        } catch (Exception e) {
            logger.info("发生了错误,{}",e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//手动让Spring回滚该事务
        }
        return i;
    }

    /**
     * 插入50万条数据(必须先修改mysql的语句长度限制)
     * 2018-10-07 插入耗时在50秒左右
     * @return
     */
    @RequestMapping("insertList")
    public Integer insertList(){
        final int size = 500000;
        List<User> userList = new ArrayList<>(size);
        User user = null;
        Date now = new Date();
        for (int i=0;i<size;i++) {
            user = new User();
            user.setUserName("name"+(i+500001));
            user.setPassword("pwd"+(i+500001));
            user.setPhone("phone"+(i+500001));
            user.setModifyTime(now);
            userList.add(user);
        }
        long begin = System.currentTimeMillis();
        Integer b = userMapper.insertList(userList);
        System.out.println("批量插入50万条数据耗时:"+(System.currentTimeMillis()-begin)+"毫秒");
        return b;
    }

    @RequestMapping("update")
    public Integer update(){
        User user = new User();
        user.setUserId(7);
        user.setPassword("jjj");
        Integer i = userService.updatePojo(user);
        logger.info("更新影响{}条数据",i);
        return i;
    }

    @RequestMapping("delete")
    public Integer delete(){
        Integer i = userService.deleteUser(1);
        return i;
    }

}