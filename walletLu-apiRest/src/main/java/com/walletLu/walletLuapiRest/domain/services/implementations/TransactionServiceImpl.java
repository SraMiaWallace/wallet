package com.walletLu.walletLuapiRest.domain.services.implementations;

import com.walletLu.walletLuapiRest.application.request.DepositoRequestDTO;
import com.walletLu.walletLuapiRest.application.request.TransferenciaRequestDTO;
import com.walletLu.walletLuapiRest.application.request.WalletRequestDTO;
import com.walletLu.walletLuapiRest.application.response.WalletResponseDTO;
import com.walletLu.walletLuapiRest.domain.entities.TransactionEntity;
import com.walletLu.walletLuapiRest.domain.entities.TransactionTypeEntity;
import com.walletLu.walletLuapiRest.domain.entities.WalletEntity;
import com.walletLu.walletLuapiRest.domain.repositories.TransactionRepository;
import com.walletLu.walletLuapiRest.domain.services.interfaces.TransactionService;
import com.walletLu.walletLuapiRest.domain.services.interfaces.TransactionTypeService;
import com.walletLu.walletLuapiRest.domain.services.interfaces.WalletService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TransactionServiceImpl extends BaseServiceImpl<TransactionEntity, Integer> implements TransactionService {

    private static final Logger logger = LoggerFactory.getLogger(TransactionServiceImpl.class.getName());

    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.repository = transactionRepository;
    }

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    TransactionTypeService transactionTypeService;

    @Autowired
    WalletService walletService;


    public void setTransactionRepository(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public void setTransactionTypeService(TransactionTypeService transactionTypeService) {
        this.transactionTypeService = transactionTypeService;
    }

    public void setWalletService(WalletService walletService) {
        this.walletService = walletService;
    }


    /**
     * Método para traer una Wallet por su Id
     * @param wallet
     * @return
     */
    @Override
    public List<TransactionEntity> getByWalletId(WalletEntity wallet) {
        return transactionRepository.findByWalletEntity(wallet);
    }

    /**
     * Método para visulizar una cartera con todos sus detalles y movimientos
     * @param carteraDTO
     * @return
     * @throws Exception
     */
    @Override
    public WalletResponseDTO viewWalletComplete(WalletRequestDTO carteraDTO) throws Exception {

        try {

            WalletResponseDTO response = new WalletResponseDTO();

            if(carteraDTO.getWalletId() != null){
                WalletEntity cartera = walletService.getById(carteraDTO.getWalletId());

                if(cartera != null){
                    List<TransactionEntity> transactionList = this.getByWalletId(cartera);

                    if(transactionList != null) {
                        response.setCartera(cartera);
                        response.setTransaccionesList(transactionList);
                        return  response;

                    } else {
                        throw new Exception("La cartera no tiene movimientos.");
                    }
                } else {
                    throw new Exception("La cartera no existe.");
                }
            } else {
                throw new Exception("Introduce un CarteraId correcto.");
            }

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw e;
        }
    }

    /**
     * Método para crear un depósito
     * @param depositoDTO
     * @return
     * @throws Exception
     */
    @Override
    public TransactionEntity createDeposit(DepositoRequestDTO depositoDTO) throws Exception {

        try {

            TransactionTypeEntity tipoTransaccion = transactionTypeService.getById(1); // Al ser una tabla Maestra se la hardcodea el valor correspondiente(Ingreso)

            if (tipoTransaccion != null ) {

                WalletEntity cartera = walletService.getById(depositoDTO.getCarteraId());
                if (cartera != null ) {
                    if(depositoDTO.getCantidad() != null ){
                        cartera.setTotalBalance(cartera.getTotalBalance() + depositoDTO.getCantidad());
                        walletService.update(cartera);
                        return transactionRepository.saveAndFlush(new TransactionEntity(cartera, tipoTransaccion, depositoDTO.getCantidad(), new Date() ));
                    } else {
                        throw new Exception("Introduce una cantidad de deposito.");
                    }
                } else {
                    throw new Exception("No existe la cartera para hacer el depósito.");
                }
            } else {
                throw new Exception("No existe el tipo de transacción para hacer el depósito.");
            }

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw e;
        }
    }

    /**
     * Método para crear una transferencia
     * @param transferenciaDTO
     * @return
     * @throws Exception
     */
    @Override
    public List<TransactionEntity> createTransfer(TransferenciaRequestDTO transferenciaDTO) throws Exception {

        try {

            List<TransactionEntity> response = new ArrayList<>();
            TransactionTypeEntity tipoTransaccion = transactionTypeService.getById(2); // Al ser una tabla Maestra se la hardcodea el valor correspondiente(Transferencia)

            if (tipoTransaccion != null ) {

                if(transferenciaDTO.getCuentaEmisoraId() != null && transferenciaDTO.getCuentaReceptoraId() != null){
                    WalletEntity carteraEmisor = walletService.getById(transferenciaDTO.getCuentaEmisoraId());
                    WalletEntity carteraReceptor = walletService.getById(transferenciaDTO.getCuentaReceptoraId());

                    if(carteraEmisor != null && carteraReceptor != null) {
                        // Operaciones Emisor
                        carteraEmisor.setTotalBalance(carteraEmisor.getTotalBalance() - transferenciaDTO.getCantidad());
                        walletService.update(carteraEmisor);
                        TransactionEntity transaccionEmisor = new TransactionEntity(carteraEmisor, tipoTransaccion, transferenciaDTO.getCantidad(), new Date());
                        transactionRepository.saveAndFlush(transaccionEmisor);
                        response.add(transaccionEmisor);
                        // Operaciones Receptor
                        carteraReceptor.setTotalBalance(carteraReceptor.getTotalBalance() + transferenciaDTO.getCantidad());
                        walletService.update(carteraReceptor);
                        TransactionEntity transaccionReceptor = new TransactionEntity(carteraReceptor, tipoTransaccion, transferenciaDTO.getCantidad(), new Date());
                        transactionRepository.saveAndFlush(transaccionReceptor);
                        response.add(transaccionReceptor);
                    } else {
                        throw new Exception("La cuenta emisora y/o la cuenta receptora de la transferencia no existe.");
                    }
                } else {
                    throw new Exception("Introduce la cuenta emisora y/o la cuenta receptora de la transferencia.");
                }
            } else {
                throw new Exception("No existe el tipo de transacción para hacer el depósito.");
            }

            return response;

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw e;
        }
    }
}
