package com.walletLu.walletLuapiRest.application.request;

public class DepositoRequestDTO {

    Integer carteraId;
    Double cantidad;

    public DepositoRequestDTO() {
        // Constructor por defecto
    }

    // Test
    public DepositoRequestDTO(Integer carteraId, Double cantidad) {
        this.carteraId = carteraId;
        this.cantidad = cantidad;
    }

    public Integer getCarteraId() {
        return carteraId;
    }

    public void setCarteraId(Integer carteraId) {
        this.carteraId = carteraId;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }
}
