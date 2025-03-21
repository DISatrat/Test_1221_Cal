package com.example.test_1221_cal.service;

import com.example.test_1221_cal.dao.UserDAO;
import com.example.test_1221_cal.dto.UserDTO;
import com.example.test_1221_cal.mapper.UserMapper;
import com.example.test_1221_cal.model.User;
import com.example.test_1221_cal.service.user.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Mock
    private UserDAO userDAO;

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserServiceImpl userService;

    private UserDTO userDTO;
    private User userEntity;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        userDTO = new UserDTO();
        userDTO.setEmail("test@example.com");

        userEntity = new User();
        userEntity.setId(1L);
        userEntity.setEmail("test@example.com");
    }

    @Test
    void testAddUser() {
        when(userMapper.toEntity(userDTO)).thenReturn(userEntity);
        when(userDAO.save(userEntity)).thenReturn(userEntity);

        long userId = userService.addUser(userDTO);

        assertEquals(1L, userId);
        verify(userDAO, times(2)).save(userEntity);
    }
}