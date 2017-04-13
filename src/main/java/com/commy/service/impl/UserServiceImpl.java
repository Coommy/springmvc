package com.commy.service.impl;

import com.commy.bean.User;
import com.commy.dao.UserDao;
import com.commy.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by xuht on 2017/4/13.
 */
@Service
public class UserServiceImpl implements UserService{
    @Resource
    private UserDao userDao;
    /**
     * 新增用户
     *
     * @param user
     */
    @Override
    public void insertUser(User user) {
        try {
            userDao.insertUser(user);
        } catch (Exception e) {

        }
    }
}
