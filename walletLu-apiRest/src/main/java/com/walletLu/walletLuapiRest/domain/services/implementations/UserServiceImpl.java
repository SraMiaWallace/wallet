package com.walletLu.walletLuapiRest.domain.services.implementations;

import com.walletLu.walletLuapiRest.domain.entities.UserEntity;
import com.walletLu.walletLuapiRest.domain.repositories.UserRepository;
import com.walletLu.walletLuapiRest.domain.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl extends BaseServiceImpl<UserEntity, Integer> implements UserService {

    public UserServiceImpl(UserRepository userRepository) {
        this.repository = userRepository;
    }

    @Autowired
    UserRepository userRepository;


    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Método para crear un usuario
     * @param usuario
     * @return
     */
    @Override
    public UserEntity createUser(UserEntity usuario) {
        return userRepository.saveAndFlush(usuario);
    }
}
