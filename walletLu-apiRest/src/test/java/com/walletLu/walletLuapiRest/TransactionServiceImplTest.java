package com.walletLu.walletLuapiRest;

import com.walletLu.walletLuapiRest.application.request.DepositoRequestDTO;
import com.walletLu.walletLuapiRest.application.request.TransferenciaRequestDTO;
import com.walletLu.walletLuapiRest.application.request.WalletRequestDTO;
import com.walletLu.walletLuapiRest.application.response.WalletResponseDTO;
import com.walletLu.walletLuapiRest.domain.entities.TransactionEntity;
import com.walletLu.walletLuapiRest.domain.entities.TransactionTypeEntity;
import com.walletLu.walletLuapiRest.domain.entities.UserEntity;
import com.walletLu.walletLuapiRest.domain.entities.WalletEntity;
import com.walletLu.walletLuapiRest.domain.repositories.TransactionRepository;
import com.walletLu.walletLuapiRest.domain.services.implementations.TransactionServiceImpl;
import com.walletLu.walletLuapiRest.domain.services.implementations.TransactionTypeServiceImpl;
import com.walletLu.walletLuapiRest.domain.services.implementations.WalletServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)

public class TransactionServiceImplTest {

    @Mock
    TransactionRepository transactionRepository;

    @Mock
    TransactionTypeServiceImpl transactionTypeService;

    @Mock
    WalletServiceImpl walletService;

    @InjectMocks
    TransactionServiceImpl transactionService;

    @Test
    public void viewWalletComplete() {
        try {

            // Mock
            UserEntity userMock = new UserEntity(1, "Nombre", "Apellido", "0000");
            WalletEntity walletMock = new WalletEntity(1, userMock, 100.00, "Cuenta Wallet");
            TransactionTypeEntity transactionTypeMock = new TransactionTypeEntity(1, "Ingreso");
            TransactionEntity transactionMock = new TransactionEntity(1, walletMock, transactionTypeMock, 100.00, new Date());
            List<TransactionEntity> listTransactionMock = new ArrayList<>();
            listTransactionMock.add(transactionMock);
            WalletRequestDTO walletDTOMock = new WalletRequestDTO("Cuenta Wallet", 1, 1);

            // Setter
            transactionService.setTransactionRepository(transactionRepository);
            transactionService.setWalletService(walletService);

            // When
            when(walletService.getById(1)).thenReturn(walletMock);
            when(transactionService.getByWalletId(walletMock)).thenReturn(listTransactionMock);

            // Assert
            WalletResponseDTO walletDTOReturned = transactionService.viewWalletComplete(walletDTOMock);
            assertNotNull(walletDTOReturned);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void createDepositTest() {
        try {

            // Mock
            TransactionTypeEntity transactionTypeMock = new TransactionTypeEntity(1, "Ingreso");
            UserEntity userMock = new UserEntity(1, "Nombre", "Apellido", "0000");
            WalletEntity walletMock = new WalletEntity(1, userMock, 100.00, "Cuenta Wallet");
            DepositoRequestDTO depositoDTOMock = new DepositoRequestDTO(1, 50.00);
            TransactionEntity transactionMock = new TransactionEntity(1, walletMock, transactionTypeMock, 100.00, new Date());

            // Setter
            transactionService.setTransactionTypeService(transactionTypeService);
            transactionService.setWalletService(walletService);
            transactionService.setTransactionRepository(transactionRepository);

            // When
            when(transactionTypeService.getById(1)).thenReturn(transactionTypeMock);
            when(walletService.getById(1)).thenReturn(walletMock);
            when(walletService.update(walletMock)).thenReturn(walletMock);
            when(transactionRepository.saveAndFlush(any(TransactionEntity.class))).thenReturn(transactionMock);

            // Assert
            TransactionEntity transactionReturned = transactionService.createDeposit(depositoDTOMock);
            assertNotNull(transactionReturned);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void createTransfer() {
        try {

            // Mock
            TransactionTypeEntity transactionTypeMock = new TransactionTypeEntity(2, "Transferencia");
            UserEntity userMock = new UserEntity(1, "Nombre", "Apellido", "0000");
            WalletEntity walletEmitMock = new WalletEntity(1, userMock, 100.00, "Cuenta Wallet");
            WalletEntity walleRecepMock = new WalletEntity(2, userMock, 100.00, "Cuenta Wallet");
            TransferenciaRequestDTO transferenciaDTOMock = new TransferenciaRequestDTO(1, 2 , 50.00);
            TransactionEntity transactionMock = new TransactionEntity(2, walletEmitMock, transactionTypeMock, 100.00, new Date());

            // Setter
            transactionService.setTransactionTypeService(transactionTypeService);
            transactionService.setWalletService(walletService);
            transactionService.setTransactionRepository(transactionRepository);

            // When
            when(transactionTypeService.getById(2)).thenReturn(transactionTypeMock);
            when(walletService.getById(1)).thenReturn(walletEmitMock);
            when(walletService.getById(2)).thenReturn(walleRecepMock);
            when(walletService.update(walletEmitMock)).thenReturn(walletEmitMock);
            when(transactionRepository.saveAndFlush(any(TransactionEntity.class))).thenReturn(transactionMock);

            // Assert
            List<TransactionEntity> transactionReturned = transactionService.createTransfer(transferenciaDTOMock);
            assertNotNull(transactionReturned);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
