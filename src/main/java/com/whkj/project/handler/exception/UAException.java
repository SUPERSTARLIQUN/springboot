package com.whkj.project.handler.exception;

import org.apache.shiro.authc.UnknownAccountException;

/**
 * 学生组织OA系统内部异常类
 */
public class UAException extends UnknownAccountException {

    private static final long serialVersionUID = 2908828008749199746L;

    public UAException(String errorMsg){
        super(errorMsg);
    }
}
