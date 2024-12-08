package com.example.studytracker.repository;

import com.example.studytracker.entity.MUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<MUser, String> {
    @Query("SELECT u FROM MUser u WHERE u.id = :id AND u.password = :password")
    MUser findByIdAndPassword(String id, String password);
}
