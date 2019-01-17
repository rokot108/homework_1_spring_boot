package ru.volkov.homework_1_spring_boot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
public class User extends AbstractEntity {

    @Column
    @Size(min = 3, max = 10)
    private String login;

    @Column
    @Size(min = 3, max = 20)
    private String password;

    @Column
    @Email
    private String email;

    public User() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
