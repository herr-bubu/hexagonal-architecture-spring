package com.softwaremill.user.api;

import lombok.Data;

@Data
public class UserRequest {
    private String login;
    private String email;
    private String firstName;
    private String lastName;

    public UserRequest(final String login, final String email, final String firstName, final String lastName) {
        this.login = login;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}