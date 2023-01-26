package edu.cibertec.prestamoback.service;

import edu.cibertec.prestamoback.model.dao.ContratoEntity;

import java.util.List;

public interface ContratoService {
    List<ContratoEntity> listarContratos();
    ContratoEntity obtenerPorId(int id);
    void insertarContrato(ContratoEntity contrato);
    void modificarContrato(ContratoEntity contrato);
    void borrarContrato(int id);
}
