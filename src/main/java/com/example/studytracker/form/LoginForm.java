package com.example.studytracker.form;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginForm {

    @NotBlank
    @Email
    private String userId;

    @NotBlank
    private String password;
}
