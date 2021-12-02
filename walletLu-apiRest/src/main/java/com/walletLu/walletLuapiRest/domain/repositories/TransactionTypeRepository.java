package com.walletLu.walletLuapiRest.domain.repositories;

import com.walletLu.walletLuapiRest.domain.entities.TransactionTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionTypeRepository extends JpaRepository<TransactionTypeEntity, Integer> {
}
