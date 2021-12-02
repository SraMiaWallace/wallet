package com.walletLu.walletLuapiRest.domain.entities;

import javax.validation.constraints.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "USERS")
public class UserEntity {

    // VARIABLES

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="USERID")
    private Integer userId;

    @Column(name="NAME")
    @NotNull(message = "El campo NAME no puede ser nulo")
    private String name;

    @Column(name="LASTNAME")
    @NotNull(message = "El campo LASTNAME no puede ser nulo")
    private String lastName;

    @Column(name="PASSWORD")
    @NotNull(message = "El campo PASSWORD no puede ser nulo")
    private String password;


    // CONSTRUCTORES

    public UserEntity() {
        // Constructor por defecto
    }

    // Test
    public UserEntity(Integer userId, String name, String lastName, String password) {
        this.userId = userId;
        this.name = name;
        this.lastName = lastName;
        this.password = password;
    }

    public UserEntity(String name, String lastName, String password) {
        this.name = name;
        this.lastName = lastName;
        this.password = password;
    }


    // GETTERS & SETTERS

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
