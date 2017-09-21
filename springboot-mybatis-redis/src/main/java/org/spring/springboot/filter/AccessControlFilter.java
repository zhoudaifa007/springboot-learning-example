package org.spring.springboot.filter;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zhoudf2 on 2017-9-21.
 */
public class AccessControlFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response, FilterChain filterChain)throws ServletException, IOException
    {
        //设置允许跨域
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
        //允许content-type跨域
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with,content-type");
        filterChain.doFilter(request, response);
    }
}

