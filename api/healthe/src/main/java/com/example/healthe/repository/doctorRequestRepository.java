package com.example.healthe.repository;

import com.example.healthe.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface doctorRequestRepository extends JpaRepository<User,Long> {
}
