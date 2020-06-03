package com.whkj.project.handler;

import com.whkj.project.handler.exception.AuthException;
import com.whkj.project.handler.exception.UAException;
import com.whkj.project.handler.exception.IncorrectException;
import com.whkj.project.utils.RestResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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
        return RestResult.build(HttpStatus.INTERNAL_SERVER_ERROR.value(),e.getMessage());
    }

    @ExceptionHandler(value =IncorrectException.class)
    public RestResult IncorrectException(Exception e){
        log.error("错误的凭证异常，请正常登录本系统！", e);
        return RestResult.build(HttpStatus.INTERNAL_SERVER_ERROR.value(),e.getMessage());
    }

    @ExceptionHandler(value = AuthException.class)
    public RestResult AuthException(Exception e){
        log.error("认证失败", e);
        return RestResult.build(HttpStatus.INTERNAL_SERVER_ERROR.value(),e.getMessage());
    }

    @ExceptionHandler(value = UAException.class)
    public RestResult UAException(Exception e){
        log.error("用户不存在", e);
        return RestResult.build(HttpStatus.INTERNAL_SERVER_ERROR.value(),e.getMessage());
    }








}