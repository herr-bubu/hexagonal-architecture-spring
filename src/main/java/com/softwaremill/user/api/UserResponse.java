package com.softwaremill.user.api;

import com.softwaremill.user.domain.User;
import lombok.Data;

@Data
public class UserResponse {
    private Long id;
    private String login;
    private String email;
    private String firstName;
    private String lastName;

    private UserResponse(Long id, String login, String email, String firstName, String lastName) {
        this.id = id;
        this.login = login;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static UserResponse of(User user) {
        return new UserResponse(user.getId(), user.getLogin(), user.getEmail(), "", "");
    }

    public Long id() {
        return id;
    }
}