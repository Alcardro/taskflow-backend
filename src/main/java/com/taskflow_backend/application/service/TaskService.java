package com.taskflow_backend.application.service;


import com.taskflow_backend.api.dto.TaskRequestDTO;
import com.taskflow_backend.domain.model.Task;
import com.taskflow_backend.infrastructure.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task createTask(TaskRequestDTO request){

        Task task = new Task();
        task.setTitle(request.getTitle());
        task.setDescription((request.getDescription()));
        task.setCompleted(false);
        return taskRepository.save(task);
    }

}
