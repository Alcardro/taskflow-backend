package com.taskflow_backend.api.dto;

import jakarta.validation.constraints.NotBlank;

public class AuthRequestDTO {
    @NotBlank
    private String username;
    @NotBlank
    private String password;

    // Getters, setters, constructores
    public AuthRequestDTO() {}
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}