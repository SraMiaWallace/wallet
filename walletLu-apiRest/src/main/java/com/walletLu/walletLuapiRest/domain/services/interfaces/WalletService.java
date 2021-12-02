package com.walletLu.walletLuapiRest.domain.services.interfaces;

import com.walletLu.walletLuapiRest.application.request.WalletRequestDTO;
import com.walletLu.walletLuapiRest.domain.entities.WalletEntity;

public interface WalletService extends BaseService<WalletEntity, Integer> {

    WalletEntity createWallet(WalletRequestDTO carteraDTO) throws Exception;
}
