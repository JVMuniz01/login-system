package com.loginSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loginSystem.entity.Task;
import com.loginSystem.entity.User;

public interface TaskRepository extends JpaRepository<Task, Long> {
	List<Task> findByUserId(Long id);
	List<Task> findByUser(User user);
}
