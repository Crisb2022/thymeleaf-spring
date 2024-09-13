package com.uqai.capacitacion.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Order(1)
@Aspect
@Slf4j
@Component
public class GreetingAspectOrderTwo {


    @Before("GreetingServicePointcut.greetingAspectPointcut()")
    public void before(JoinPoint joinPoint) {
        var method = joinPoint.getSignature().getName();
        var args = Arrays.toString(joinPoint.getArgs());
        log.info("Este es un Before de Greeting order 1: " + method + " Args" + args);
    }
}
