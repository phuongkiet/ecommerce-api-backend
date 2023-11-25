package com.tutorial.ecommerceapi.api.controller.home;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/home")
public class HomeController {
    @GetMapping
    public String home(){
        return "Home page";
    }
}
