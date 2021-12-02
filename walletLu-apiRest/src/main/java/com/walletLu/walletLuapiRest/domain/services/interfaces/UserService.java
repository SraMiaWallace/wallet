package com.walletLu.walletLuapiRest.domain.services.interfaces;


import com.walletLu.walletLuapiRest.domain.entities.UserEntity;


public interface UserService extends BaseService<UserEntity, Integer> {

    UserEntity createUser(UserEntity usuario);

}
