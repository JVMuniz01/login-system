package com.loginSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loginSystem.dto.TaskDTO;
import com.loginSystem.entity.User;
import com.loginSystem.repository.UserRepository;
import com.loginSystem.service.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController {
	
	@Autowired
	private final TaskService taskService;
	
	@Autowired
	private final UserRepository userRepository;
	
	public TaskController(TaskService taskService, UserRepository userRepository) {
        this.taskService = taskService;
        this.userRepository = userRepository;
    }
	
	@PostMapping
	public TaskDTO createTask(@RequestBody TaskDTO taskDTO) {
		String email = "j040vmr@gmail.com";
		User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
		return taskService.createTask(taskDTO, user);
	}
	
	@GetMapping
	   public List<TaskDTO> getTasks() {
		String email = "j040vmr@gmail.com";
		User user = userRepository.findByEmail(email)
	            .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

	    return taskService.getUserTask(user);
	       
	}
	@PutMapping("/{taskId}")
    public TaskDTO updateTask(@PathVariable Long taskId, @RequestBody TaskDTO taskDTO) {
        return taskService.updateTask(taskId, taskDTO);
    }
	@DeleteMapping("/{taskId}")
    public void deleteTask(@PathVariable Long taskId) {
        taskService.deleteTask(taskId);
    }
	
}
