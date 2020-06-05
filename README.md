# SpringBoot V1.0版本初始框架

**项目技术：**SpringBoot  Shiro   Mybatis  Mysql

**资源地址：**

​	数据文件：项目根目录/sql/shiro.sql

​	测试路径地址：

​		用户登录接口：GET请求：localhost:8080/demo/login?userName=admin&password=123123

​		用户分页查询接口：GET请求：localhost:8080/demo/User/Api/findUserPage

**项目初始配置：**

   自定义配置工具：
     	Java自定义响应体
    	 密码加密工具
	     json工具类
 	    http工具类
	     状态码工具类

**Shiro常见异常类：**

|        异常父类         | 异常子类                      | 异常信息                                           |
| :---------------------: | ----------------------------- | -------------------------------------------------- |
| AuthenticationException | CredentitalsException         | 凭证异常                                           |
|                         | IncorrectCredentialsException | 不正确的凭证                                       |
|                         | ExpiredCredentialsException   | 凭证过期                                           |
|                         | ConcurrentAccessException     | 并发访问异常（多个用户同时登录时抛出）             |
|                         | UnknownAccountException       | 未知的账号                                         |
|                         | ExcessiveAttemptsException    | 认证次数超过限制                                   |
|                         | DisabledAccountException      | 禁用的账号                                         |
|                         | LockedAccountException        | 账号被锁定                                         |
|                         | AccountException              | 账号异常                                           |
|                         | pportedTokenException         | 使用了不支持的Token                                |
| AuthorizationException  | UnauthorizedException         | 抛出以指示请求的操作或对请求的资源的访问是不允许的 |
|                         | UnanthenticatedException      | 当尚未完成成功认证时，尝试执行授权操作时引发异常   |
