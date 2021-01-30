package com.softwaremill.user.domain;

import com.softwaremill.user.api.UserIdResponse;
import com.softwaremill.user.api.UserRequest;
import io.vavr.control.Option;

public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Option<User> findUserById(Long userId) {
        return userRepository.findById(userId);
    }

    public UserIdResponse createUser(UserRequest request) {
        User user = User.builder().email(request.getEmail()).login(request.getLogin()).build();

        User savedUser = userRepository.save(user);

        return UserIdResponse.of(savedUser.getId());
    }
}