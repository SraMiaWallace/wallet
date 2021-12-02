package com.walletLu.walletLuapiRest.application.rest;

import com.walletLu.walletLuapiRest.application.request.WalletRequestDTO;
import com.walletLu.walletLuapiRest.domain.entities.WalletEntity;
import com.walletLu.walletLuapiRest.domain.services.interfaces.WalletService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rest/wallet")
public class WalletController {

    @Autowired
    WalletService walletService;

    @GetMapping("/getListAllWallets")
    @Operation(
            summary = "Ver todas las Carteras",
            description = "Método que muestra todas las carteras de la aplicación.",
            tags = { "Wallet / Cartera" }
    )
    public List<WalletEntity> getListAllWallets() {
        return walletService.getAll();
    }


    @PostMapping("/createWallet")
    @Operation(
            summary = "Crear Cartera",
            description = "Método para crear una Cartera, dándole un Nombre y un UsuarioId (1 y 2 creados por defecto). El WalletId se deja a 0.",
            tags = { "Wallet / Cartera" }
    )
    public WalletEntity createWallet(@RequestBody WalletRequestDTO carteraDTO) throws Exception {
        return walletService.createWallet(carteraDTO);
    }


}
