package com.loginSystem.mapper;

import com.loginSystem.dto.TaskDTO;
import com.loginSystem.entity.Task;
import com.loginSystem.entity.User;

public class TaskMapper {
	public static TaskDTO toDTO(Task task) {
        return new TaskDTO(
            task.getId(),
            task.getTitle(),
            task.getDescription(),
            task.isCompleted()
        );
}
	public static Task toEntity(TaskDTO dto, User user) {
        Task task = new Task();
        task.setTitle(dto.title());
        task.setDescription(dto.description());
        task.setCompleted(dto.completed());
        
        task.setUser(user);
        return task;
    }
}