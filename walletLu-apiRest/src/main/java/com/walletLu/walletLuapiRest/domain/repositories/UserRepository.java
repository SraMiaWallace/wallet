package com.walletLu.walletLuapiRest.domain.repositories;

import com.walletLu.walletLuapiRest.domain.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

}
