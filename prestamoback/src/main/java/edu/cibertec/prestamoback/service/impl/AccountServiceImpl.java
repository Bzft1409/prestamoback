package edu.cibertec.prestamoback.service.impl;

import edu.cibertec.prestamoback.model.dao.AccountEntity;
import edu.cibertec.prestamoback.repository.AccountRepository;
import edu.cibertec.prestamoback.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<AccountEntity> obtenerCuentas() {
        return this.accountRepository.findAll();
    }

    @Override
    public AccountEntity obtenerPorId(int id) {
        return this.accountRepository.findById(id).get();
    }

    @Override
    public void insertarCuenta(AccountEntity cuenta) {
        this.accountRepository.save(cuenta);
    }

    @Override
    public void modificarCuenta(AccountEntity cuenta) {
        this.accountRepository.save(cuenta);
    }

    @Override
    public void eliminarCuenta(int id) {
        this.accountRepository.deleteById(id);
    }
}
