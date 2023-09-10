package com.gogiari.myproject.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gogiari.myproject.user.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String> {
}
