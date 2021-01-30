package com.softwaremill.user.infrastructure;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "USERS")
@NoArgsConstructor
public class UserModel {
    @Id
    @GeneratedValue
    @Getter
    private Long id;

    @Column
    @Getter
    private String login;

    @Column
    @Getter
    private String email;

    public UserModel(String login, String email) {
        this.login = login;
        this.email = email;
    }
}