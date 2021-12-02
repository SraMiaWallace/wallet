package com.walletLu.walletLuapiRest;

import com.walletLu.walletLuapiRest.domain.entities.UserEntity;
import com.walletLu.walletLuapiRest.domain.repositories.UserRepository;
import com.walletLu.walletLuapiRest.domain.services.implementations.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.junit.Assert.*;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    UserServiceImpl userService;


    @Test
    public void testCreateUser() {

        // Mock
        UserEntity userMock = new UserEntity(1, "Nombre", "Apellido", "0000");

        userService.setUserRepository(userRepository);
        when(userRepository.saveAndFlush(any(UserEntity.class))).thenReturn(userMock);

        UserEntity userReturned = userService.createUser(userMock);

        assertNotNull(userReturned);
    }

}