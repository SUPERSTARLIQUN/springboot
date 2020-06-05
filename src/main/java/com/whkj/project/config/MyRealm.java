package com.whkj.project.config;

import com.whkj.project.entity.Menu;
import com.whkj.project.entity.Role;
import com.whkj.project.entity.User;
import com.whkj.project.handler.exception.UAException;
import com.whkj.project.service.MenuService;
import com.whkj.project.service.RoleService;
import com.whkj.project.service.UserService;
import com.whkj.project.utils.MD5Util;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import sun.security.provider.MD5;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 配置自定义Realm
 */
@Slf4j
public class MyRealm extends AuthorizingRealm {


    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private MenuService menuService;




    /**
     *进行授权逻辑处理
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        log.info("已经进入权限认证···");
        String primaryPrincipal =(String) principalCollection.getPrimaryPrincipal();

        //创建返回实体
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        List<Role> roleList = roleService.findUserRole(primaryPrincipal);
        List<Menu> permissionList = menuService.findUserMenu(primaryPrincipal);

        //角色与权限都是List<E>集合
        Set<String> roleSet = roleList.stream().map(Role::getPerms).collect(Collectors.toSet());
        Set<String> permissionSet = permissionList.stream().map(Menu::getPerms).collect(Collectors.toSet());

        //将权限认证放入simpleAuthorizationInfo进行自动任务装配
        simpleAuthorizationInfo.setStringPermissions(permissionSet);
        //将角色认证放入simpleAuthorizationInfo进行自动任务装配
        simpleAuthorizationInfo.setRoles(roleSet);
        return simpleAuthorizationInfo;
    }


    /**
     * 进行用户认证处理
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        log.info("已经进入用户认证···");
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
