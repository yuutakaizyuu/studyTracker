package com.example.studytracker.repository;

import com.example.studytracker.entity.MUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends JpaRepository<MUser, String> {
    MUser findByIdAndPassword(String id, String password);
}
