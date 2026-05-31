package com.taskflow_backend.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public class AuthRequestDTO {
    @NotBlank
    @Schema(example = "juan.perez", description = "Nombre de usuario único")
    private String username;
    @NotBlank
    @Schema(example = "MiClaveSegura123", description = "Contraseña del usuario")
    private String password;

    // Getters, setters, constructores
    public AuthRequestDTO() {}
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}