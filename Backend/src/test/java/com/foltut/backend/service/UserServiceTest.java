package com.foltut.backend.service;

import com.foltut.backend.dto.requestDTO.ChangeEmailRequestDTO;
import com.foltut.backend.dto.requestDTO.ChangePasswordRequestDTO;
import com.foltut.backend.dto.userDTO.UserRegisterDTO;
import com.foltut.backend.exception.UsernameAlreadyExistsException;
import com.foltut.backend.model.User;
import com.foltut.backend.repository.UserRepository;
import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

import javax.transaction.Transactional;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @BeforeEach
    public void setupData() {
        userRepository.save(User.builder()
                .username("john.doe")
                .firstName("John")
                .lastName("Doe")
                .email("john.doe@example.com")
                .password(bCryptPasswordEncoder.encode("password"))
                .build());
    }

    @Test
    void registerUser() {
        userService.registerUser(UserRegisterDTO.builder()
                .username("Capra")
                .firstName("Foltut")
                .lastName("Dan")
                .email("capra")
                .password("password")
                .build());

        Optional<User> user = userRepository.findByUsername("Capra");

        assertEquals("Capra", user.get().getUsername(), "find by username");
    }

    @Test
    void registerInvalidUser() {
        assertThrows(UsernameAlreadyExistsException.class,() -> userService.registerUser(UserRegisterDTO.builder()
                .username("john.doe")
                .firstName("John")
                .lastName("Doe")
                .email("john.doe@example.com")
                .password(bCryptPasswordEncoder.encode("password"))
                .build()));
    }

    @Test
    void changeEmail() {
        userService.changeEmail(new ChangeEmailRequestDTO("john.doe@example.com",
                "john.doe.new@example.com",
                bCryptPasswordEncoder.encode("password")));

        Optional<User> user = userRepository.findByUsername("john.doe");

        assertEquals("john.doe.new@example.com", user.get().getEmail(), "find by username");
    }
}