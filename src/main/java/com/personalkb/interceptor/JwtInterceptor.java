package com.personalkb.interceptor;

import com.personalkb.utils.JwtUtil;
import com.personalkb.utils.UserContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

public class JwtInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler) {

        String token = request.getHeader("token");

        Long userId =
                JwtUtil.parseToken(token);

        UserContext.set(userId);

        return true;
    }

    @Override
    public void afterCompletion(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler,
            Exception ex) {

        UserContext.remove();
    }
}