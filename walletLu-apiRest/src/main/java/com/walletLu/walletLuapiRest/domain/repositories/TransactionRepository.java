package com.walletLu.walletLuapiRest.domain.repositories;

import com.walletLu.walletLuapiRest.domain.entities.TransactionEntity;
import com.walletLu.walletLuapiRest.domain.entities.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, Integer> {

    List<TransactionEntity> findByWalletEntity(WalletEntity wallet);

}
