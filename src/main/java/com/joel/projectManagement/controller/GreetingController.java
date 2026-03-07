package com.joel.projectManagement.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class GreetingController {
    @GetMapping("/greet")
    public String sayHello (@RequestParam(value = "name", required = false) String name) {
        return name != null && name.length() > 0  ? "Hello, " + name : "Hello";
    }
}
