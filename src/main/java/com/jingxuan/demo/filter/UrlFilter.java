package com.jingxuan.demo.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Author: Xuan Jing
 * @Date: 2020/6/25 10:40 PM
 */
@WebFilter(filterName = "test", urlPatterns = "/test")
@Slf4j
public class UrlFilter implements Filter {

    private static String INFO = "info";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        log.info("----------------------->过滤器被创建");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        String requestURI = req.getRequestURI();
        log.info("--------------------->过滤器：请求地址"+requestURI);
        if(!requestURI.contains(INFO)){
            servletRequest.getRequestDispatcher("/failed").forward(servletRequest, servletResponse);
        }else{
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

        log.info("----------------------->过滤器被销毁");
    }
}
