package com.taskflow_backend.api.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public class TaskRequestDTO {

    @NotBlank(message = "El titulo es obligatorio")
    @Schema(example = "Comprar leche", description = "Título de la tarea")
    private String title;
    @Schema(example = "Ir al supermercado y comprar leche deslactosada", description = "Descripción detallada (opcional)")
    private String description;

    public TaskRequestDTO() {
    }

    public TaskRequestDTO(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
