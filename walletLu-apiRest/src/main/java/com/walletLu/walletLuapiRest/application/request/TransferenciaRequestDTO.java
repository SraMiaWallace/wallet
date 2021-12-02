package com.walletLu.walletLuapiRest.application.request;

public class TransferenciaRequestDTO {

    private Integer cuentaEmisoraId;
    private Integer cuentaReceptoraId;
    private Double cantidad;

    public TransferenciaRequestDTO() {
        // Constructor por defecto
    }

    // Test
    public TransferenciaRequestDTO(Integer cuentaEmisoraId, Integer cuentaReceptoraId, Double cantidad) {
        this.cuentaEmisoraId = cuentaEmisoraId;
        this.cuentaReceptoraId = cuentaReceptoraId;
        this.cantidad = cantidad;
    }

    public Integer getCuentaEmisoraId() {
        return cuentaEmisoraId;
    }

    public void setCuentaEmisoraId(Integer cuentaEmisoraId) {
        this.cuentaEmisoraId = cuentaEmisoraId;
    }

    public Integer getCuentaReceptoraId() {
        return cuentaReceptoraId;
    }

    public void setCuentaReceptoraId(Integer cuentaReceptoraId) {
        this.cuentaReceptoraId = cuentaReceptoraId;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }
}
