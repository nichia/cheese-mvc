package org.launchcode.cheesemvc.models.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class User {
    @NotNull
    @Size(min=5, max=15, message = "Username must be between 5 and 15 characters")
    private String username;

    @Email(message = "Email should be valid")
    private String email;

    @NotNull
    @Size(min=6, message = "Password must be at least 6 characters long")
    private String password;
    private Date created;
    private int userId;
    private static int nextId = 1;

    public User(String username, String email, String password) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
        this.created = new Date();
    }

    public User() {
        userId = nextId;
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
