package com.walletLu.walletLuapiRest.domain.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "WALLETS")
public class WalletEntity {

    // VARIABLES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="WALLETID")
    private Integer walletId;

    @ManyToOne
    @JoinColumn(name="USERID")
    @NotNull(message = "El campo USERID no puede ser nulo")
    private UserEntity userId;

    @Column(name="TOTALBALANCE")
    @NotNull(message = "El campo TOTALBALANCE no puede ser nulo")
    private Double totalBalance;

    @Column(name="NAME")
    @NotNull(message = "El campo NAME no puede ser nulo")
    private String name;


    // CONSTRUCTORES

    public WalletEntity() {
        // Constructor por defecto
    }

    // Test
    public WalletEntity(Integer walletId, UserEntity userId, Double totalBalance, String name) {
        this.walletId = walletId;
        this.userId = userId;
        this.totalBalance = totalBalance;
        this.name = name;
    }

    public WalletEntity(UserEntity userId, Double totalBalance, String name) {
        this.userId = userId;
        this.totalBalance = totalBalance;
        this.name = name;
    }


    // GETTERS & SETTERS

    public Integer getWalletId() {
        return walletId;
    }

    public void setWalletId(Integer walletId) {
        this.walletId = walletId;
    }

    public UserEntity getUserId() {
        return userId;
    }

    public void setUserId(UserEntity userId) {
        this.userId = userId;
    }

    public Double getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(Double totalBalance) {
        this.totalBalance = totalBalance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
