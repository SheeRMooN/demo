package ru.vlasov.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import ru.vlasov.entity.UserEntity;
import ru.vlasov.service.UserService;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserControllerTest {
    @Autowired
    private UserController userController;

    @MockBean
    private UserService userService;

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAllUser() {
    }

    @Test
    void getUserById() {
    }

    @Test
    void getAllRecordsForUser() {
    }

    @Test
    void getUserByName() {
    }

    @Test
    void getUserByNamePart() {
    }

    @Test
    void createUser() {
    }

    @Test
    void update() {
    }

    @Test
    void deleteUser() {
    }
}