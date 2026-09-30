package com.universe.opensky.k8s.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {
    @GetMapping("/welcome")
    public String welcome(){
        return "Hi User , welcome to kubernetes universe";
    }
}
