package com.whkj.project.controller;

import com.github.pagehelper.PageInfo;
import com.whkj.project.entity.User;
import com.whkj.project.service.UserService;
import com.whkj.project.utils.RestResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
    @ResponseBody
    @RequiresPermissions(value = "user:add1",logical = Logical.OR)
    public RestResult findUserPage(User user, PageInfo pageInfo){
        PageInfo userPage = userService.findUserPage(user, pageInfo);
        return RestResult.ok(userPage);
    }


    /**
     * reids  CRUD操作
     * @return
     */
    @GetMapping(value = "saveRedis")
    @ResponseBody
    public RestResult saveRedis(Integer id){
        return RestResult.ok(userService.selectByPrimaryKey(id));
    }

}
