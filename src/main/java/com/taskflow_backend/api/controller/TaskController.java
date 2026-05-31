package com.taskflow_backend.api.controller;

import com.taskflow_backend.api.dto.TaskRequestDTO;
import com.taskflow_backend.application.service.TaskService;
import com.taskflow_backend.domain.Task;
import com.taskflow_backend.repository.infrastructure.TaskRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> getAllTask(){
        return taskRepository.findAll();
    }

    @PostMapping
    public Task createTask(@Valid @RequestBody TaskRequestDTO request){
        return taskService.createTask(request);
    }

}
