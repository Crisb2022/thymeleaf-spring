package com.uqai.capacitacion.configuration;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


/**
 * Antes de los interceptores se ejecutan los filtros del spring
 */
@Slf4j
@Component
public class InterceptorConfig implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) {
        var token = request.getHeader("authorization");

        log.info("token: {}", token);
        if (!token.contains("hola-como-estas"))  return false;
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView model){
        log.info("postHandle -------");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception exception){
        log.error("Se completo la peticion ", exception);
    }
}
