package com.example.genarateinterest.dto;

import com.example.genarateinterest.dto.enm.RoleName;

public class Usr {
    private Long id;
    private String avatar;
    private String name;
    private RoleName role;
    private String email;
    private String username;

    public Usr() {
    }

    public Usr(Long id, String avatar, String name, RoleName role, String email) {
        this.id = id;
        this.avatar = avatar;
        this.name = name;
        this.role = role;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RoleName getRole() {
        return role;
    }

    public void setRole(RoleName role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Usr{" +
                "id=" + id +
                ", avatar='" + avatar + '\'' +
                ", name='" + name + '\'' +
                ", role=" + role +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
