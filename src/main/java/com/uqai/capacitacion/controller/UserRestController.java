package com.uqai.capacitacion.controller;

import com.uqai.capacitacion.configuration.PropertiesConfig;
import com.uqai.capacitacion.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "/rest")
public class UserRestController {

    @Value("#{'${app.lastname}'.toUpperCase()}")
    private String lastName;

    @Autowired
    private PropertiesConfig email;

    @Autowired
    private Environment environment;

    @GetMapping("/list-words")
    public Map<String, Object> getWords(@Value("${app.name}") String name) {
        var age = environment.getProperty("app.age", Integer.class);
        return Map.of("name", name,
                "lastName", lastName,
                "age", age,
                "emails",  email.getEmail());
    }

    @PostMapping
    public UserDTO responseUser(@RequestBody UserDTO user) {
        if (!StringUtils.hasText(user.getEmail()) ) user.setEmail("No hay email ");
        return user;
    }
}
