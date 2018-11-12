package com.example.mybatis_demo;


import com.example.mybatis_demo.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisDemoApplicationTests {
//    @Autowired
//    UserMapper userMapper;

//    @Test
//    public void contextLoads() {
//    }

    //    @Before
//    public void testBefore(){
//        System.out.println("before方法");
//    }
//
//    @BeforeClass
//    public static void testBeforeClass(){
//        System.out.println("beforeClass方法");
//    }
//
//    @Test
//    public void testUpdateRows(){
//        Integer i = userMapper.update();
//        Assert.assertEquals(new Integer(3),i);
//    }
//
//    @Test
//    public void testInsertRows(){
//        Integer i = userMapper.insertBatch();
//        Assert.assertEquals(new Integer(3),i);
//    }
    @Test(expected = NullPointerException.class)
    public void whenCreateEmptyOptional_thenNull() {
        Optional<User> emptyOpt = Optional.empty();
        emptyOpt.get();
    }

//    @Test
//    public void testCache(){
//
//    }

}
