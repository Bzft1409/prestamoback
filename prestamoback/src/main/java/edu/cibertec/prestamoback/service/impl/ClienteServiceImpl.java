package edu.cibertec.prestamoback.service.impl;

import edu.cibertec.prestamoback.model.dao.ClienteEntity;
import edu.cibertec.prestamoback.repository.ClienteRepository;
import edu.cibertec.prestamoback.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClienteServiceImpl implements ClienteService {
    private final ClienteRepository clienteRepository;
    @Autowired
    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
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
}
