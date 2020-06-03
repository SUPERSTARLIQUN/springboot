package com.whkj.project.config;

import com.whkj.project.entity.User;
import com.whkj.project.handler.exception.UAException;
import com.whkj.project.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

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
        if(token == null || StringUtils.isBlank((String) token.getPrincipal())){
            throw new UAException("token令牌验证失败！");
        }

        User user = userService.queryUserByName((String) token.getPrincipal());
        if (user == null) {
            throw new UAException("查询暂无此用户！");
        }
        return new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), ByteSource.Util.bytes(user.getUsername()), getName());
    }
}
