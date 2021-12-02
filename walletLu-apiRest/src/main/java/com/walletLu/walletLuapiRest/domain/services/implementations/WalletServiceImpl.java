package com.walletLu.walletLuapiRest.domain.services.implementations;

import com.walletLu.walletLuapiRest.application.request.WalletRequestDTO;
import com.walletLu.walletLuapiRest.domain.entities.UserEntity;
import com.walletLu.walletLuapiRest.domain.entities.WalletEntity;
import com.walletLu.walletLuapiRest.domain.repositories.WalletRepository;
import com.walletLu.walletLuapiRest.domain.services.interfaces.UserService;
import com.walletLu.walletLuapiRest.domain.services.interfaces.WalletService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class WalletServiceImpl extends BaseServiceImpl<WalletEntity, Integer> implements WalletService {


    private static final Logger logger = LoggerFactory.getLogger(WalletServiceImpl.class.getName());

    public WalletServiceImpl(WalletRepository walletRepository) {
        this.repository = walletRepository;
    }


    @Autowired
    WalletRepository walletRepository;

    @Autowired
    UserService userService;


    public void setWalletRepository(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     * Método para crear una wallet
     * @param carteraDTO
     * @return
     * @throws Exception
     */
    @Override
    public WalletEntity createWallet(WalletRequestDTO carteraDTO) throws Exception {

        try {

            UserEntity user = userService.getById(carteraDTO.getUserId());
            if (user != null) {
                return walletRepository.saveAndFlush(new WalletEntity(user, 0.00, carteraDTO.getWalletName()));
            } else {
                throw new Exception("No existe el usuario para crear la cartera.");
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw e;
        }
    }

}
