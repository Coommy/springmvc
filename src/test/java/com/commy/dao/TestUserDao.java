package com.commy.dao;

import com.commy.bean.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by xuht on 2017/4/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/spring-mybatis.xml"})
public class TestUserDao {
    @Resource
    private UserDao userDao;
    @Test
    public void testInsertUser(){
        User user = new User();
        user.setId(1);
        user.setPassword("123456");
        user.setNickname("张三");
        user.setFirstName("张");
        userDao.insertUser(user);

    }
}
