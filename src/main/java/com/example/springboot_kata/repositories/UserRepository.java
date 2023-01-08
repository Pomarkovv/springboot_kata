package com.example.springboot_kata.repositories;

import com.example.springboot_kata.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

}
