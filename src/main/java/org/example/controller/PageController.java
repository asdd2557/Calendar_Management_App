package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping("/home")
    public String homePage() {
        return "/home/home";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "/login/login";
    }

    @GetMapping("/signup")
    public String signupPage() {
        {
            return "/signup/signup";
        }
    }
}
