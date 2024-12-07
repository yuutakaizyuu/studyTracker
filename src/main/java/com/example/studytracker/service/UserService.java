package com.example.studytracker.service;

import com.example.studytracker.entity.MUser;
import com.example.studytracker.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public MUser login(String userId, String password) {
        return userRepository.findByIdAndPassword(userId, password);
    }
}
