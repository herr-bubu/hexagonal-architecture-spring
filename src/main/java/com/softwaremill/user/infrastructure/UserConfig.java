package com.softwaremill.user.infrastructure;

import com.softwaremill.user.domain.UserRepository;
import com.softwaremill.user.domain.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    @Bean
    UserService userService(final UserRepository userRepository) {
        return new UserService(userRepository);
    }
}
