package com.whkj.project.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 * 配置shiro配置文件类
 */

@Slf4j
@Configuration
public class shiroConfig {

    /**
     * 创建ShiroFilterFactoryBean
     *Shiro内置过滤器，可以实现权限相关的拦截器
     *    常用的过滤器：
     *      anon: 无需认证（登录）可以访问
     *      authc: 必须认证才可以访问
     *      user: 如果使用rememberMe的功能可以直接访问
     *      perms： 该资源必须得到资源权限才可以访问
     *      role: 该资源必须得到角色权限才可以访问
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager")DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //添加Shiro内置过滤器
        Map<String,String> filterMap = new LinkedHashMap();
        /**
         *前后端分离是由前台路由判断跳转野蛮，后端只负责返回json数据
         * shiroFilterFactoryBean.setLoginUrl("");
         * shiroFilterFactoryBean.setSuccessUrl("");
         * shiroFilterFactoryBean.setUnauthorizedUrl("/unauthorized");
         */
        // 除上以外所有 url都必须认证通过才可以访问，未通过认证自动访问 LoginUrl
        filterMap.put("/login","anon");
        filterMap.put("/**", "user");
        // 重要的地方：使用自定义的过滤器
        LinkedHashMap<String, Filter> map = new LinkedHashMap<>();
        map.put("user", new MyFormAuthenticationFilter());
        // 添加过滤器
        shiroFilterFactoryBean.setFilters(map);
        //设置路径拦截规则
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        return shiroFilterFactoryBean;
    }

    /**
     * 创建DefaultWebSecurityManager
     */
    @Bean(name="securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("MyRealm")MyRealm myRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联realm
        securityManager.setRealm(myRealm);
        return securityManager;
    }


    /**
     * 创建Realm
     */
    @Bean(name="MyRealm")
    public MyRealm getRealm(){
        return new MyRealm();
    }
}
