package com.whkj.project.config;

import com.whkj.project.entity.User;
import com.whkj.project.handler.exception.UAException;
import com.whkj.project.service.UserService;
import com.whkj.project.utils.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import sun.security.provider.MD5;

import java.util.List;

/**
 * 配置自定义Realm
 */
public class MyRealm extends AuthorizingRealm {


    @Autowired
    private UserService userService;


    /**
     *进行授权逻辑处理
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println(principalCollection);
        return null;
    }


    /**
     * 进行用户认证处理
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取用户输入用户名以及密码
        String username = (String) token.getPrincipal();
        String password = new String((char[]) token.getCredentials());
        if(token == null || StringUtils.isBlank(username)){
            throw new UnknownAccountException("token令牌验证失败！");
        }
        // 通过用户名到数据库查询用户信息
        User user = userService.queryUserByName(username);
        if (user == null||!StringUtils.equals(password,user.getPassword())) {
            throw new UnknownAccountException("用户名或密码错误！");
        }
        return new SimpleAuthenticationInfo(user.getUsername(), password, ByteSource.Util.bytes(user.getUsername()), getName());
    }
}
