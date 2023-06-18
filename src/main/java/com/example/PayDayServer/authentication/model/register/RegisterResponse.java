package com.example.PayDayServer.authentication.model.register;

public class RegisterResponse {
    public RegisterResponse(String status) {
        this.status = status;
    }

    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
