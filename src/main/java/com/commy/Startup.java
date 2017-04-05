package com.commy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by xuht on 2017/4/5.
 */
public class Startup {
    public static void main(String args[]){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath*:spring/applicationContext.xml");
        System.out.println("run success");
    }
}
