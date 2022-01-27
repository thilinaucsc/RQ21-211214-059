package com.example.genarateinterest.dto;

public class LoginResponse {
    private String accessToken;
    private Usr user;

    public LoginResponse() {
    }

    public LoginResponse(String accessToken, Usr user) {
        this.accessToken = accessToken;
        this.user = user;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Usr getUser() {
        return user;
    }

    public void setUser(Usr user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "accessToken='" + accessToken + '\'' +
                ", user=" + user +
                '}';
    }
}
