package edu.cibertec.prestamoback.service;

import edu.cibertec.prestamoback.model.dao.ClienteEntity;
import edu.cibertec.prestamoback.model.dao.ContratoEntity;

import java.util.List;

public interface ClienteService {
    List<ClienteEntity> listarCliente();
    ClienteEntity obtenerPorId(int id);
    void insertarCliente(ClienteEntity cliente);
    void modificarCliente(ClienteEntity cliente);
    void borrarCliente(int id);
    List<ClienteEntity> paginadoDiez(int pagina);
    ContratoEntity pagarPrestamo(int contrato,int cuenta);

}
