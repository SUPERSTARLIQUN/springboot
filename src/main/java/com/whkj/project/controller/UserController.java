package com.whkj.project.controller;

import com.github.pagehelper.PageInfo;
import com.whkj.project.entity.User;
import com.whkj.project.service.UserService;
import com.whkj.project.utils.RestResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/User/Api")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 查询用户分页附带模糊查询接口
     * @param user
     * @param pageInfo
     * @return
     */
    @GetMapping(value = "/findUserPage")
    public RestResult findUserPage(User user, PageInfo pageInfo){
        //1.获取Subject
        Subject subject = SecurityUtils.getSubject();
        //2.封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken("账号","密码");

        //3.执行登录方法
        try {
            subject.login(token);
            //登录成功
            return RestResult.ok(userService.findUserPage(user,pageInfo));
        } catch (UnknownAccountException e) {
            //登录失败:用户名不存在
            throw new RuntimeException("用户名不存在！");
        }catch (IncorrectCredentialsException e) {
            //登录失败:密码错误
            // model.addAttribute("msg", "密码错误");
            throw new RuntimeException("密码错误！");
        }
    }

}
