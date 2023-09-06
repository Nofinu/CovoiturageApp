package com.example.gatewayservice.aspect;

import com.example.gatewayservice.tools.RestClient;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;;

@Component
@Aspect
public class LoginAspect {
    @Before("execution(* com.example.gatewayservice.controller.logedController.*.*(..))")
    public void testToken() {
        RestClient<String> restClient = new RestClient<>("http://localhost:8084/api/test");
        HttpServletRequest servletRequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String token = servletRequest.getHeader("Authorization");
        if(!restClient.testToken(token, String.class)) {
            throw new RuntimeException();
        }
    }
}
