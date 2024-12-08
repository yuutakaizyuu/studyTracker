package com.example.studytracker.controller;

import com.example.studytracker.entity.MUser;
import com.example.studytracker.form.LoginForm;
import com.example.studytracker.form.UserRegistrationForm;
import com.example.studytracker.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class LoginController {
    private final UserService userService;

    @GetMapping("/signup")
    public String signup(@ModelAttribute UserRegistrationForm userRegistrationForm) {
        return "signup";
    }

    // ログイン画面へ遷移
    @GetMapping("/login")
    public String login(@ModelAttribute LoginForm loginForm) {
        return "login";
    }

    @PostMapping("/login")
    public String postLogin() {
        MUser user = userService.login("sample@example.com", "password");
        if(user != null) {
            return "redirect:/";
        } else {
            return "login";
        }
    }
}