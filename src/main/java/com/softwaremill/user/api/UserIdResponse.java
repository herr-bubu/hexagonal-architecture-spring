package com.softwaremill.user.api;

public class UserIdResponse {
    private final Long id;


    private UserIdResponse(Long id) {
        this.id = id;
    }

    public static UserIdResponse of(Long id) {
        return new UserIdResponse(id);
    }

    public Long id() {
        return id;
    }
}