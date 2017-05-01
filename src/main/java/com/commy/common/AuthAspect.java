package com.commy.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by coom on 2017/5/1.
 */
@Aspect
public class AuthAspect {

    @Before("execution(* com.commy.controller.MainController.*(..))")
    public void authority(){
        System.out.println("模拟执行权限检查!");
    }
}
