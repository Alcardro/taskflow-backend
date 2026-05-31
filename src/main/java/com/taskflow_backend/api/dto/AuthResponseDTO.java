package com.taskflow_backend.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public class AuthResponseDTO {

    @Schema(example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ",
            description = "Token JWT para autenticar siguientes peticiones")
    private String token;

    public AuthResponseDTO(String token) { this.token = token; }
    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }
}