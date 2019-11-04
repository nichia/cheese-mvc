package org.launchcode.cheesemvc.models;

import java.util.Date;

public class User {
    private String username;
    private String email;
    private String password;
    private Date created;
    private int userId;
    private static int nextId = 1;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.created = new Date();
        this.userId = nextId;
        nextId++;
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreated() {
        return created;
    }
}
