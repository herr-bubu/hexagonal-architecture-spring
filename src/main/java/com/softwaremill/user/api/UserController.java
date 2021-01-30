package com.softwaremill.user.api;

import com.softwaremill.user.domain.User;
import com.softwaremill.user.domain.UserService;
import io.vavr.control.Option;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static io.vavr.API.*;
import static io.vavr.Patterns.$None;
import static io.vavr.Patterns.$Some;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    UserIdResponse createUser(@RequestBody UserRequest request) {
        return userService.createUser(request);
    }

    @GetMapping("{userId}")
    ResponseEntity<?> getUser(@PathVariable("userId") final Long userId) {
        final Option<User> user = userService.findUserById(userId);
        return Match(user).of(
                Case($Some($()), v -> ResponseEntity.ok(UserResponse.of(v))),
                Case($None(), () -> ResponseEntity.badRequest().body("user.not.found"))
        );
    }
}