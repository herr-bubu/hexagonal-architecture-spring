package com.softwaremill.user.infrastructure;

import io.vavr.control.Option;
import org.springframework.data.repository.Repository;

public interface UserJpaRepository extends Repository<UserModel, Long> {
    Option<UserModel> findByEmail(String email);

    Option<UserModel> findByLogin(String email);

    Option<UserModel> findById(Long id);

    UserModel save(UserModel user);
}
