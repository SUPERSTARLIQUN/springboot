package com.whkj.project.config;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.json.JSONObject;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * 配置shiro自定义拦截响应类
 */
public class MyFormAuthenticationFilter extends FormAuthenticationFilter {

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setContentType("application/json; charset=utf-8");
        PrintWriter out = httpServletResponse.getWriter();
        JSONObject json = new JSONObject();
        json.put("status","401");
        json.put("msg","非法访问，没有请求头的Token令牌！");
        out.println(json);
        out.flush();
        out.close();
        return false;
    }
}
