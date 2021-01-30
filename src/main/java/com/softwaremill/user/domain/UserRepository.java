package com.softwaremill.user.domain;

import io.vavr.control.Option;

public interface UserRepository {
    Option<User> findByEmail(String email);

    Option<User> findByLogin(String email);

    Option<User> findById(Long id);

    User save(User user);
}