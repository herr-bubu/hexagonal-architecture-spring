package com.softwaremill.user.infrastructure;

import com.softwaremill.user.domain.User;
import com.softwaremill.user.domain.UserRepository;
import io.vavr.control.Option;
import org.springframework.stereotype.Service;

@Service
public class UserDatabaseRepository implements UserRepository {

    private UserJpaRepository jpaRepository;

    public UserDatabaseRepository(UserJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Option<User> findByEmail(String email) {
        return null;
    }

    @Override
    public Option<User> findByLogin(String email) {
        return null;
    }

    @Override
    public User save(User user) {
        final UserModel userModel = new UserModel(user.getLogin(), user.getEmail());
        final UserModel savedUser = jpaRepository.save(userModel);
        return User
                .builder()
                .id(savedUser.getId())
                .email(savedUser.getEmail())
                .login(savedUser.getLogin())
                .build();
    }

    public Option<User> findById(Long userId) {
        return jpaRepository
                .findById(userId)
                .map(userModel -> User.builder()
                        .id(userModel.getId())
                        .email(userModel.getEmail())
                        .login(userModel.getLogin())
                        .build());

    }
}