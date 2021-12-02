package com.walletLu.walletLuapiRest.domain.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TRANSACTIONTYPES")
public class TransactionTypeEntity {

    // VARIABLES

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="TRANSACTIONTYPEID")
    private Integer transactionTypeId;

    @Column(name="NAME")
    @NotNull(message = "El campo NAME no puede ser nulo")
    private String name;


    // CONSTRUCTORES

    public TransactionTypeEntity() {
        // Constructor por defecto
    }

    // Test
    public TransactionTypeEntity(Integer transactionTypeId, String name) {
        this.transactionTypeId = transactionTypeId;
        this.name = name;
    }


    // GETTERS & SETTERS

    public Integer getTransactionTypeId() {
        return transactionTypeId;
    }

    public void setTransactionTypeId(Integer transactionTypeId) {
        this.transactionTypeId = transactionTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
