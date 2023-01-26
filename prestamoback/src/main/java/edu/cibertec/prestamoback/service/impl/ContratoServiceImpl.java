package edu.cibertec.prestamoback.service.impl;

import edu.cibertec.prestamoback.model.dao.ContratoEntity;
import edu.cibertec.prestamoback.repository.ContratoRepository;
import edu.cibertec.prestamoback.service.ContratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContratoServiceImpl implements ContratoService {
    private final ContratoRepository contratoRepository;
    @Autowired
    public ContratoServiceImpl(ContratoRepository contratoRepository) {
        this.contratoRepository = contratoRepository;
    }

    @Override
    public List<ContratoEntity> listarContratos() {
        return this.contratoRepository.findAll();
    }

    @Override
    public ContratoEntity obtenerPorId(int id) {
        return this.contratoRepository.findById(id).get();
    }

    @Override
    public void insertarContrato(ContratoEntity contrato) {
        this.contratoRepository.save(contrato);
    }

    @Override
    public void modificarContrato(ContratoEntity contrato) {
        this.contratoRepository.save(contrato);
    }

    @Override
    public void borrarContrato(int id) {
        this.contratoRepository.deleteById(id);
    }
}
