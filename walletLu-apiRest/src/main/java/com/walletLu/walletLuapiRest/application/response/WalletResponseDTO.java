package com.walletLu.walletLuapiRest.application.response;

import com.walletLu.walletLuapiRest.domain.entities.TransactionEntity;
import com.walletLu.walletLuapiRest.domain.entities.WalletEntity;

import java.util.List;

public class WalletResponseDTO {

    private WalletEntity cartera;
    private List<TransactionEntity> transaccionesList;

    public WalletResponseDTO() {
        // Constructor por defecto
    }

    // Test
    public WalletResponseDTO(WalletEntity cartera, List<TransactionEntity> transaccionesList) {
        this.cartera = cartera;
        this.transaccionesList = transaccionesList;
    }

    public WalletEntity getCartera() {
        return cartera;
    }

    public void setCartera(WalletEntity cartera) {
        this.cartera = cartera;
    }

    public List<TransactionEntity> getTransaccionesList() {
        return transaccionesList;
    }

    public void setTransaccionesList(List<TransactionEntity> transaccionesList) {
        this.transaccionesList = transaccionesList;
    }
}
