package com.example.PayDayServer.authentication.model.login;

public class LoginResponse {
    public LoginResponse(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    private String login;
}
