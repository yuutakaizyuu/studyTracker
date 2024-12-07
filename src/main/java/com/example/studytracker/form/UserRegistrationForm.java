package com.example.studytracker.form;

import lombok.Data;

@Data
public class UserRegistrationForm {
    private String userId;
    private String userName;
    private String password;
    // パスワード確認用
    private String confirmPassword;
}
