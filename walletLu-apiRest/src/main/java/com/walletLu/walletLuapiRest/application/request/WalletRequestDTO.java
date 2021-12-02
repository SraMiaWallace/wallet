package com.walletLu.walletLuapiRest.application.request;

public class WalletRequestDTO {

    private String walletName;
    private Integer userId;
    private Integer walletId;


    public WalletRequestDTO() {
        // Constructor por defecto
    }

    // Test
    public WalletRequestDTO(String walletName, Integer userId, Integer walletId) {
        this.walletName = walletName;
        this.userId = userId;
        this.walletId = walletId;
    }

    public String getWalletName() {
        return walletName;
    }

    public void setWalletName(String walletName) {
        this.walletName = walletName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getWalletId() {
        return walletId;
    }

    public void setWalletId(Integer walletId) {
        this.walletId = walletId;
    }
}
