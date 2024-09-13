package com.uqai.capacitacion.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingServicePointcut {

    @Pointcut("execution(* com.uqai.capacitacion.service.GreetingService.*(..))")
    public void greetingAspectPointcut() {
    }
}
