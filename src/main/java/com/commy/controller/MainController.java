package com.commy.controller;

import com.commy.bean.User;
import com.commy.dao.UserDao;
import org.codehaus.jackson.map.Serializers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by xuht on 2017/3/27.
 */
@Controller
@RequestMapping(value = "/main")
public class MainController extends BaseController{
    @Resource
    private UserDao userDao;

    @RequestMapping(value = "/insertUser", method = RequestMethod.GET)
    @ResponseBody
    public String insertUser() {
        User user = new User();
        user.setId(2);
        user.setNickname("nick");
        user.setPassword("123456");
        userDao.insertUser(user);
        return buildMessage(ResultModal.SUCCESS,"success");
    }
}
