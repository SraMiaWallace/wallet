package com.walletLu.walletLuapiRest.application.rest;

import com.walletLu.walletLuapiRest.application.request.DepositoRequestDTO;
import com.walletLu.walletLuapiRest.application.request.TransferenciaRequestDTO;
import com.walletLu.walletLuapiRest.application.request.WalletRequestDTO;
import com.walletLu.walletLuapiRest.application.response.WalletResponseDTO;
import com.walletLu.walletLuapiRest.domain.entities.TransactionEntity;
import com.walletLu.walletLuapiRest.domain.services.interfaces.TransactionService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rest/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @GetMapping("/getListAllTransactions")
    @Operation(
            summary = "Ver todas las Transacciones",
            description = "Método que muestra todas las transacciones de la aplicación.",
            tags = { "Transacciones" }
    )
    public List<TransactionEntity> getListAllTransactions() {
        return transactionService.getAll();
    }

    @PostMapping("/viewWalletComplete")
    @Operation(
            summary = "Ver Cartera",
            description = "Método que muestra una cartera con todos sus datos y un histórico de sus transacciones. IMPORTANTE, solo hay que introducir el WalletId",
            tags = { "Wallet / Cartera" }
    )
    public WalletResponseDTO viewWalletComplete(@RequestBody WalletRequestDTO carteraDTO) throws Exception {
        return transactionService.viewWalletComplete(carteraDTO);
    }

    @PostMapping("/createDeposit")
    @Operation(
            summary = "Crear Depósito",
            description = "Método que crea un Depósito, dándole un CarteraId (1 y 2 creados por defecto) y una Cantidad (Ejemplo formato válido: 0.00).",
            tags = { "Transacciones" }
    )
    public TransactionEntity createDeposit(@RequestBody DepositoRequestDTO depositoDTO) throws Exception {
        return transactionService.createDeposit(depositoDTO);
    }

    @PostMapping("/createTransfer")
    @Operation(
            summary = "Crear Transferencia",
            description = "Método que crea un Transferencia, dándole un Cuenta A y una cuenta B, (1 y 2 creados por defecto).",
            tags = { "Transacciones" }
    )

    public List<TransactionEntity> createTransfer(@RequestBody TransferenciaRequestDTO transferenciaDTO) throws Exception {
        return transactionService.createTransfer(transferenciaDTO);
    }
}
