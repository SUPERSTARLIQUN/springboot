package com.whkj.project.controller;

import com.whkj.project.utils.RestResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

@RestController
public class TestController {


    @GetMapping(value = "/login")
    public RestResult login1(String userName,String password) throws Exception {
        try {
            Subject subject = SecurityUtils.getSubject();
            System.out.println(subject);
            subject.login(new UsernamePasswordToken(userName,password));
            System.out.println("登录成功！one");
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return RestResult.ok("进入控制器1");
    }


    @GetMapping(value = "/netease")
    public RestResult login2(){
        return RestResult.ok("进入控制器netease");
    }


    @GetMapping(value = "/tencent")
    public RestResult login3(){
        return RestResult.ok("进入控制器tencent");
    }


    @GetMapping(value = "/tianmei")
    public RestResult login4(){
        return RestResult.ok("进入控制器tianmei");
    }


    @GetMapping(value = "/unauthorized")
    public RestResult unauthorized(){
        return RestResult.build(500,"该用户登录未授权!");
    }
}
