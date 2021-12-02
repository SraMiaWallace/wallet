package com.walletLu.walletLuapiRest.domain.services.implementations;

import com.walletLu.walletLuapiRest.domain.entities.TransactionTypeEntity;
import com.walletLu.walletLuapiRest.domain.repositories.TransactionTypeRepository;
import com.walletLu.walletLuapiRest.domain.services.interfaces.TransactionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionTypeServiceImpl extends BaseServiceImpl<TransactionTypeEntity, Integer> implements TransactionTypeService{

    public TransactionTypeServiceImpl(TransactionTypeRepository transactionTypeRepository) {
        this.repository = transactionTypeRepository;
    }

    @Autowired
    TransactionTypeRepository transactionTypeRepository;
}
