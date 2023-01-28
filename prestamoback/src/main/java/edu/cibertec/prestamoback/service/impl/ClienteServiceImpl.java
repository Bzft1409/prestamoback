package edu.cibertec.prestamoback.service.impl;

import edu.cibertec.prestamoback.model.dao.AccountEntity;
import edu.cibertec.prestamoback.model.dao.ClienteEntity;
import edu.cibertec.prestamoback.model.dao.ContratoEntity;
import edu.cibertec.prestamoback.repository.AccountRepository;
import edu.cibertec.prestamoback.repository.ClienteRepository;
import edu.cibertec.prestamoback.repository.ContratoRepository;
import edu.cibertec.prestamoback.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClienteServiceImpl implements ClienteService {
    private final ClienteRepository clienteRepository;
    private final AccountRepository accountRepository;
    private final ContratoRepository contratoRepository;
    @Autowired
    public ClienteServiceImpl(ClienteRepository clienteRepository, AccountRepository accountRepository, ContratoRepository contratoRepository) {
        this.clienteRepository = clienteRepository;
        this.accountRepository = accountRepository;
        this.contratoRepository = contratoRepository;
    }

    @Override
    public List<ClienteEntity> listarCliente() {
        return this.clienteRepository.findAll();
    }

    @Override
    public ClienteEntity obtenerPorId(int id) {
        return this.clienteRepository.findById(id).get();
    }

    @Override
    public void insertarCliente(ClienteEntity cliente) {
        this.clienteRepository.save(cliente);
    }

    @Override
    public void modificarCliente(ClienteEntity cliente) {
        this.clienteRepository.save(cliente);
    }

    @Override
    public void borrarCliente(int id) {
        this.clienteRepository.deleteById(id);
    }

    @Override
    public List<ClienteEntity> paginadoDiez(int pagina) {
        var lista=this.clienteRepository.findAll();
        if (lista.size()<(pagina+1)*20) return lista.subList(10*(pagina-1),lista.size());
        else return lista.subList(10*(pagina-1),(10*pagina)-1);
    }

    @Override
    public ContratoEntity pagarPrestamo(int contrato, int cuenta) {
        ContratoEntity contratoEntity= contratoRepository.findById(contrato).get();
        AccountEntity cuentaEntity= accountRepository.findById(contrato).get();
        if(contratoEntity.getCurrency().toLowerCase().equals(cuentaEntity.getCurrency().toLowerCase())){
            if(contratoEntity.getAmount()>cuentaEntity.getAmount()){
                contratoEntity.setAmount(contratoEntity.getAmount()-cuentaEntity.getAmount());
                cuentaEntity.setAmount(0.00);
                contratoRepository.save(contratoEntity);
                accountRepository.save(cuentaEntity);
                return contratoEntity;
            } else if (contratoEntity.getAmount()<cuentaEntity.getAmount()) {
                cuentaEntity.setAmount(cuentaEntity.getAmount()-contratoEntity.getAmount());
                contratoEntity.setAmount(0.00);
                contratoRepository.save(contratoEntity);
                accountRepository.save(cuentaEntity);
                return contratoEntity;
            } else return contratoEntity;
        } else return contratoEntity;
    }
}
