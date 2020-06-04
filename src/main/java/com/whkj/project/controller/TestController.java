package com.whkj.project.controller;

import com.whkj.project.utils.MD5Util;
import com.whkj.project.utils.RestResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

@RestController
public class TestController {


    @GetMapping(value = "/login")
    public RestResult login1(String userName,String password){
        Subject subject = SecurityUtils.getSubject();
        System.out.println(MD5Util.shiroEncrypt(userName,password));
        subject.login(new UsernamePasswordToken(userName,MD5Util.shiroEncrypt(userName,password)));
        return RestResult.ok("进入登录接口");
    }

    @GetMapping(value = "/unauthorized")
    public RestResult unauthorized(){
        return RestResult.build(500,"该用户登录未授权!");
    }


}
