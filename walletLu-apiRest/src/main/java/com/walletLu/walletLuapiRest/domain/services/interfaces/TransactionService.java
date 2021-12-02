package com.walletLu.walletLuapiRest.domain.services.interfaces;

import com.walletLu.walletLuapiRest.application.request.DepositoRequestDTO;
import com.walletLu.walletLuapiRest.application.request.TransferenciaRequestDTO;
import com.walletLu.walletLuapiRest.application.request.WalletRequestDTO;
import com.walletLu.walletLuapiRest.application.response.WalletResponseDTO;
import com.walletLu.walletLuapiRest.domain.entities.TransactionEntity;
import com.walletLu.walletLuapiRest.domain.entities.WalletEntity;

import java.util.List;

public interface TransactionService extends BaseService<TransactionEntity, Integer> {

    List<TransactionEntity> getByWalletId(WalletEntity wallet);
    WalletResponseDTO viewWalletComplete(WalletRequestDTO carteraDTO) throws Exception;
    TransactionEntity createDeposit(DepositoRequestDTO depositoDTO) throws Exception;
    List<TransactionEntity> createTransfer(TransferenciaRequestDTO transferenciaDTO) throws Exception;

}
