package com.walletLu.walletLuapiRest.domain.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "TRANSACTIONS")
public class TransactionEntity {

    // VARIABLES

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="TRANSACTIONID")
    private Integer transactionId;

    @ManyToOne
    @JoinColumn(name="WALLETID")
    @NotNull(message = "El campo WALLETID no puede ser nulo")
    private WalletEntity walletEntity;

    @ManyToOne
    @JoinColumn(name="TRANSACTIONTYPEID")
    @NotNull(message = "El campo TRANSACTIONTYPEID no puede ser nulo")
    private TransactionTypeEntity transactionTypeEntity;

    @Column(name="AMOUNT")
    @NotNull(message = "El campo AMOUNT no puede ser nulo")
    private Double amount;

    @Column(name="CREATIONDATE")
    @NotNull(message = "El campo CREATIONDATE no puede ser nulo")
    private Date creationDate;


    // CONSTRUCTORES

    public TransactionEntity() {
        // Constructor por defecto
    }

    // Test
    public TransactionEntity(Integer transactionId, WalletEntity walletEntity, TransactionTypeEntity transactionTypeEntity, Double amount, Date creationDate) {
        this.transactionId = transactionId;
        this.walletEntity = walletEntity;
        this.transactionTypeEntity = transactionTypeEntity;
        this.amount = amount;
        this.creationDate = creationDate;
    }

    public TransactionEntity(WalletEntity walletEntity, TransactionTypeEntity transactionTypeEntity, Double amount, Date creationDate) {
        this.walletEntity = walletEntity;
        this.transactionTypeEntity = transactionTypeEntity;
        this.amount = amount;
        this.creationDate = creationDate;
    }


    // GETTERS & SETTERS

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public WalletEntity getWalletEntity() {
        return walletEntity;
    }

    public void setWalletEntity(WalletEntity walletEntity) {
        this.walletEntity = walletEntity;
    }

    public TransactionTypeEntity getTransactionTypeEntity() {
        return transactionTypeEntity;
    }

    public void setTransactionTypeEntity(TransactionTypeEntity transactionTypeEntity) {
        this.transactionTypeEntity = transactionTypeEntity;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
