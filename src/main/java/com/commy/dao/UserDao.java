package com.commy.dao;

import com.commy.bean.User;
import org.springframework.stereotype.Component;

/**
 * Created by xuht on 2017/4/13.
 */
@Component
public interface UserDao {
    /**
     * 插入用户
     * @param user
     */
    void insertUser(User user);
}
