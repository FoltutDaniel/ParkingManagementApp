package com.foltut.backend.service;

import com.foltut.backend.dto.requestDTO.ChangeEmailRequestDTO;
import com.foltut.backend.dto.requestDTO.ChangePasswordRequestDTO;
import com.foltut.backend.dto.userDTO.UserRegisterDTO;
import com.foltut.backend.model.User;
import com.foltut.backend.repository.UserRepository;
import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.TestPropertySource;

import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @BeforeEach
    public void setupData(){
        jdbcTemplate.execute("insert into user_table(id, username, first_name, last_name, email, password)" +
                " values(5, 'UserTest', 'User', 'Test', 'test@mail.com', 'password')");
    }

    @Test
    void registerUser() {
        userService.registerUser(new UserRegisterDTO("Capra", "Foltut", "Dan", "capra", "password"));

        Optional<User> user = userRepository.findByUsername("Capra");

        assertEquals("Capra", user.get().getUsername(), "find by username");
    }

    @Test
    void changeEmail() {
        userService.changeEmail(new ChangeEmailRequestDTO("test@mail.com", "test_new@mail.com", "password"));
        Optional<User> user = userRepository.findByUsername("UserTest");

        assertEquals("test_new@mail.com", user.get().getEmail(), "find by username");
    }


    @AfterEach()
    public void setupAfterTransaction(){
        jdbcTemplate.execute("DELETE FROM user_table");
    }
}