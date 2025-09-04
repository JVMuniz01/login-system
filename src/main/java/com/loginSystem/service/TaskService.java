package com.loginSystem.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.loginSystem.dto.TaskDTO;
import com.loginSystem.entity.Task;
import com.loginSystem.entity.User;
import com.loginSystem.mapper.TaskMapper;
import com.loginSystem.repository.TaskRepository;


@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;
	
	
	//Create
	public TaskDTO createTask(TaskDTO taskDTO, User user) {
		Task task = TaskMapper.toEntity(taskDTO, user);
        Task saved = taskRepository.save(task);
        return TaskMapper.toDTO(saved);
	}
	
	public List<TaskDTO> getUserTask(User user){
		return taskRepository.findByUser(user)
                .stream()
                .map(TaskMapper::toDTO)
                .toList();
	}
	public TaskDTO updateTask(Long taskId, TaskDTO updatedDTO) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task não encontrada"));

        task.setTitle(updatedDTO.title());
        task.setDescription(updatedDTO.description());
        task.setCompleted(updatedDTO.completed());

        Task saved = taskRepository.save(task);
        return TaskMapper.toDTO(saved);
    }
	
	public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }
}
