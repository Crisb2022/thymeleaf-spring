package com.uqai.capacitacion.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService {

    @Override
    public String sayHello(String name, String message) {
        return "Hola como estas: " + name + " Mi mensaje es: " + message;
    }

    @Override
    public String sayHelloAfterReturning(String name, String message) {
        return name + " Estas usando AfterReturning: " + message;
    }

    @Override
    public String sayHelloAfterThrowing(String name, String message) {
        throw new RuntimeException("Error en la prueba del after throwing: " + message);
    }
}
