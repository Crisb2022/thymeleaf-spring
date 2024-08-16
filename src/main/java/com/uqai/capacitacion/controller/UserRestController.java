package com.uqai.capacitacion.controller;

import com.uqai.capacitacion.configuration.PropertiesConfig;
import com.uqai.capacitacion.dto.UserDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    // http://localhost:8090/rest/http-servlet-request?name=Samantha&lastName=Jara&age=25&email=sam@gmail.com
    @GetMapping("/http-servlet-request")
    public UserDTO httpServletRequest(HttpServletRequest request) {
        var name = request.getParameter("name");
        var lastname = request.getParameter("lastName");
        var age = Integer.parseInt(request.getParameter("age"));
        var emailRequest = request.getParameter("email");
        return new UserDTO(name, lastname, age, emailRequest);
    }

    @GetMapping("/request-param")
    public UserDTO requestParam(@RequestParam String name, @RequestParam String lastName, @RequestParam String age, @RequestParam String email) {
        return new UserDTO(name, lastName, Integer.parseInt(age), email);
    }

    // http://localhost:8090/rest/path-param/Samantha/Jara/25/sam@gmail.com
    @GetMapping("/path-param/{name}/{lastName}/{age}/{email}")
    public UserDTO pathParam(@PathVariable String name, @PathVariable String lastName, @PathVariable(name = "age") int age, @PathVariable(name = "email") String email) {
        return new UserDTO(name, lastName, age, email);
    }
}
