package com.jingxuan.demo.servie.impl;

import com.jingxuan.demo.mapper.UserMapper;
import com.jingxuan.demo.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.doReturn;

class UserServiceImplTest {
    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserMapper userMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getUserById() {
        User user = new User();
        doReturn(user).when(userMapper).selectByPrimaryKey(1);

        Assertions.assertEquals(user, userService.getUserById(1));
    }
}