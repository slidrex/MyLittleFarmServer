package com.example.PayDayServer.authentication.model.register;

public class RegisterResponse {
    private String login;

    public RegisterResponse(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
