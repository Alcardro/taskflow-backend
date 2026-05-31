package com.taskflow_backend.api.dto;
import jakarta.validation.constraints.NotBlank;

public class TaskRequestDTO {

    @NotBlank(message = "El titulo es obligatorio")
    private String title;
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
