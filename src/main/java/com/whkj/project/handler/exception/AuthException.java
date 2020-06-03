package com.whkj.project.handler.exception;

import org.apache.shiro.authc.AuthenticationException;

public class AuthException extends AuthenticationException {

    private static final long serialVersionUID = 2908828008749199746L;

    public AuthException(String errorMsg){
        super(errorMsg);
    }
}
