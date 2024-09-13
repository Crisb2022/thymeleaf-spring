package com.uqai.capacitacion.controller;

import com.uqai.capacitacion.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    @GetMapping
    public ResponseEntity<?> sayHello() {
        return ResponseEntity.ok(Collections.singletonMap("message", greetingService.sayHello("Cristian", "Tu lo vas a lograr")));
    }

    @GetMapping("/after")
    public ResponseEntity<?> sayHelloAfterThrowing() {
        return ResponseEntity.ok(Collections.singletonMap("message", greetingService.sayHelloAfterThrowing("Cristian", "Tu lo vas a lograr")));
    }
}
