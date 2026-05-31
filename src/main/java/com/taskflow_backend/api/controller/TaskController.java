package com.taskflow_backend.api.controller;

import com.taskflow_backend.api.dto.TaskRequestDTO;
import com.taskflow_backend.application.service.TaskService;
import com.taskflow_backend.domain.model.Task;
import com.taskflow_backend.infrastructure.repository.TaskRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@Tag(name = "Tareas", description = "Endpoints para la gestión de tareas del usuario autenticado")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskService taskService;

    @GetMapping
    @Operation(summary = "Obtener todas las tareas", description = "Retorna la lista de tareas del usuario actual")
    @ApiResponse(responseCode = "200", description = "Lista de tareas obtenida exitosamente")
    public List<Task> getAllTask(){
        return taskRepository.findAll();
    }

    @PostMapping
    @Operation(summary = "Crear una nueva tarea")
    public Task createTask(@Valid @RequestBody TaskRequestDTO request){
        return taskService.createTask(request);
    }

}
