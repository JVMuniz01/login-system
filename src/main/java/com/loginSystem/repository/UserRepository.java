package com.loginSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loginSystem.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
