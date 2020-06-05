package com.whkj.project.handler;

import com.whkj.project.handler.exception.AuthException;
import com.whkj.project.handler.exception.UAException;
import com.whkj.project.handler.exception.IncorrectException;
import com.whkj.project.utils.RestResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import java.util.Set;

/**
 * @author ThinkPad
 * 自定义异常处理
 */
@Slf4j
@RestControllerAdvice
@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class CustomizeExceptionHandler {

    /**
     * 系统内部异常类
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public RestResult handleException(Exception e) {
        String msg = "";
        log.error("系统内部异常，异常信息", e);
        return RestResult.build(HttpStatus.INTERNAL_SERVER_ERROR.value(),"系统内部异常，请联系管理员！");
    }

    /**
     * Shiro在登录认证过程中，认证失败需要抛出的异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = AuthenticationException.class)
    public RestResult handleAuthenticationException(AuthenticationException e) {
        log.error("用户认证过程中，认证失败!", e.getMessage());
        return RestResult.build(HttpStatus.METHOD_NOT_ALLOWED.value(),e.getMessage());
    }


    /**
     *shiro在授权过程中，授权失败需要抛出的信息
     */
    @ExceptionHandler(value = AuthorizationException.class)
    public RestResult handleAuthorizationException(AuthorizationException e) {
        String message = "" ;
        log.error("用户授权过程中，授权失败!", e.getMessage());
        if (e instanceof UnauthorizedException) {
            message = "请求的资源的访问是不允许的";
        }else if(e instanceof UnauthenticatedException){
            message = "当尚未完成成功认证时，尝试执行授权操作时引发异常";
        }else{
            message = e.getMessage();
        }
        return RestResult.build(HttpStatus.METHOD_NOT_ALLOWED.value(),message);
    }







}