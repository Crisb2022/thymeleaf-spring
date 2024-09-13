package com.uqai.capacitacion.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/*
Dentro de la jerarquia de order, el orden 1 engloba al resto de interceptores si el orden 1 tiene un after
es el primero en entrar y el ultimo en salir

Around envuelve todos
:D
 */
@Order(2)
@Aspect
@Slf4j
@Component
public class GreetingAspect {

    @Before("GreetingServicePointcut.greetingAspectPointcut()")
    public void before(JoinPoint joinPoint) {
        var method = joinPoint.getSignature().getName();
        var args = Arrays.toString(joinPoint.getArgs());
        log.info("order 2 Antes: " + method + " Args" + args);
    }

    @After("GreetingServicePointcut.greetingAspectPointcut()")
    public void after(JoinPoint joinPoint) {
        var method = joinPoint.getSignature().getName();
        var args = Arrays.toString(joinPoint.getArgs());
        log.info("order 2 Despues: " + method + " Args" + args);
    }

    @AfterReturning("GreetingServicePointcut.greetingAspectPointcut()")
    public void afterReturning(JoinPoint joinPoint) {
        var method = joinPoint.getSignature().getName();
        var args = Arrays.toString(joinPoint.getArgs());
        log.info("AfterReturning : " + method + " Args" + args);
    }

    @Around("GreetingServicePointcut.greetingAspectPointcut()")
    public Object adviceAround(ProceedingJoinPoint joinPoint) throws Throwable {
        var method = joinPoint.getSignature().getName();
        var args = Arrays.toString(joinPoint.getArgs());
        log.info("Antes de proceed Around : " + method + " Args" + args);
        Object result = joinPoint.proceed();
        log.info("Despues del proceed Around : " + method + " Args" + args);
        return result;
    }
}
