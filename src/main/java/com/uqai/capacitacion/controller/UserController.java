package com.uqai.capacitacion.controller;

import com.uqai.capacitacion.configuration.PropertiesConfig;
import com.uqai.capacitacion.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/no-rest")
public class UserController {

    @Value("#{'${app.lastname}'.toUpperCase()}")
    private String lastName;

    @Autowired
    private PropertiesConfig email;

    @Autowired
    private Environment environment;

    @GetMapping("/hola-mundo")
    public String helloWorld (Model model) {
        model.addAttribute("name", "Cristian");
        model.addAttribute("lastName", "Caceres");
        model.addAttribute("age", "26");
        model.addAttribute("email", "cris@gmail,.com");
        return "holaMundoEnHTML";
    }

    @GetMapping("/hola-mundo-properties")
    public String helloWorldProperties (Model model, @Value("${app.name}") String name) {
        model.addAttribute("name", name);
        model.addAttribute("lastName", lastName);
        model.addAttribute("age", environment.getProperty("app.age", Integer.class));
        model.addAttribute("email", email.getEmail());
        return "holaMundoEnHTML";
    }

    @PostMapping("/post-value")
    public String postValue(Model model, @RequestBody UserDTO user){
        model.addAttribute("name", user.getName());
        model.addAttribute("lastName", user.getLastName());
        model.addAttribute("age", user.getAge());
        model.addAttribute("email", user.getEmail());
        return "holaMundoEnHTML";
    }

    @GetMapping("/list")
    public String listUser(Model model){
        List<UserDTO> users = Arrays.asList(
           new UserDTO("Cris", "Caceres", 26,null ),
           new UserDTO("Raquel", "Bano", 52,"raquel@gmail.com" ),
           new UserDTO("Fred", "Caceres", 53,"freddy@hotmail.com" )
        ) ;
        model.addAttribute("users", users);
        return "listThymeleaf";
    }
}
