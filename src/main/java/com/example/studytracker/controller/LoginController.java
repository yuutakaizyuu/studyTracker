package com.example.studytracker.controller;

import com.example.studytracker.entity.MUser;
import com.example.studytracker.form.LoginForm;
import com.example.studytracker.form.UserRegistrationForm;
import com.example.studytracker.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class LoginController {
    private final UserService userService;

    /**
     * 会員登録機能
     */
    // 新規会員登録画面へ遷移
    @GetMapping("/signup")
    public String signup(@ModelAttribute UserRegistrationForm userRegistrationForm) {
        return "signup";
    }

    //会員登録
    @PostMapping("/signup")
    public String postSignup(@Validated UserRegistrationForm form, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return signup(form);
        }

        // メールアドレスが有効か確認する
        if (userService.isUserIdAvailable(form.getUserId())) {
            return "redirect:/login";
        } else {
            return signup(form);
        }
    }

    /**
     * ログイン機能
     */
    // ログイン画面へ遷移
    @GetMapping("/login")
    public String login(@ModelAttribute LoginForm loginForm) {
        return "login";
    }

    @PostMapping("/login")
    public String postLogin(@Validated LoginForm form, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            // TODO
            return null;
        }

        // TODO
        MUser user = userService.login(form);
        if(user != null) {
            return null;
        } else {
            return "redirect:/top";
        }
    }
}