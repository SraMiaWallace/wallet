package com.walletLu.walletLuapiRest.domain.repositories;

import com.walletLu.walletLuapiRest.domain.entities.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends JpaRepository<WalletEntity, Integer> {
}
