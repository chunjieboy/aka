package com.qf.wfx.merchant.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class JWTFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        StringBuffer requestURL = request.getRequestURL();
        String uri = new String(requestURL);
        String method = request.getMethod();

        if (uri.endsWith("/customer/login") || uri.endsWith("/memeber/login")
                || uri.contains("swagger-")||uri.contains("api-docs")
                ||uri.contains("favicon") || "OPTIONS".equals(method)) {

            // 放行
            filterChain.doFilter(request,response);
        } else {
            try {
                //判断请求的请求头是否带上 "Token"
                if (request.getHeader("token") != null) {
                    // 验证token
                    Jws<Claims> jws = Jwts.parser().setSigningKey("qf123").parseClaimsJws(request.getHeader("token"));
                    filterChain.doFilter(request,response);
                }
            } catch (Exception e) {
                e.printStackTrace();
                response.getWriter().write("认证失败");
                System.out.println("认证失败");
                return;
            }
        }
    }

    @Override
    public void destroy() {

    }
}
