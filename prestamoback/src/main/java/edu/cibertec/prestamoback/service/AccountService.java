package edu.cibertec.prestamoback.service;

import edu.cibertec.prestamoback.model.dao.AccountEntity;

import java.util.List;

public interface AccountService {
    List<AccountEntity> obtenerCuentas();
    AccountEntity obtenerPorId(int id);
    void insertarCuenta(AccountEntity cuenta);
    void modificarCuenta(AccountEntity cuenta);
    void eliminarCuenta(int id);
}
