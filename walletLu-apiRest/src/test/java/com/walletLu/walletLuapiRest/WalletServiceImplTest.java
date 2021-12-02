package com.walletLu.walletLuapiRest;

import com.walletLu.walletLuapiRest.application.request.WalletRequestDTO;
import com.walletLu.walletLuapiRest.domain.entities.UserEntity;
import com.walletLu.walletLuapiRest.domain.entities.WalletEntity;
import com.walletLu.walletLuapiRest.domain.repositories.WalletRepository;
import com.walletLu.walletLuapiRest.domain.services.implementations.UserServiceImpl;
import com.walletLu.walletLuapiRest.domain.services.implementations.WalletServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class WalletServiceImplTest {

    @Mock
    private WalletRepository walletRepository;

    @Mock
    UserServiceImpl userService;

    @InjectMocks
    WalletServiceImpl walletService;

    @Test
    public void createWalletTest() {

        try {
            // Mock
            UserEntity userMock = new UserEntity(1, "Nombre", "Apellido", "0000");
            WalletEntity walletMock = new WalletEntity(1, userMock, 100.00, "Cuenta Wallet");
            WalletRequestDTO walletDTOMock = new WalletRequestDTO("Cuenta Wallet", 1, 1);

            walletService.setWalletRepository(walletRepository);
            walletService.setUserService(userService);

            when(userService.getById(1)).thenReturn(userMock);
            when(walletRepository.saveAndFlush(any(WalletEntity.class))).thenReturn(walletMock);

            WalletEntity walletReturned = walletService.createWallet(walletDTOMock);

            assertNotNull(walletReturned);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
