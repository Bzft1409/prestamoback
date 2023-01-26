package edu.cibertec.prestamoback.service.impl;

import edu.cibertec.prestamoback.model.dao.DocumentoEntity;
import edu.cibertec.prestamoback.repository.DocumentoRepository;
import edu.cibertec.prestamoback.service.DocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentoServiceImpl implements DocumentoService {
    private final DocumentoRepository documentoRepository;
    @Autowired
    public DocumentoServiceImpl(DocumentoRepository documentoRepository) {
        this.documentoRepository = documentoRepository;
    }

    @Override
    public DocumentoEntity obtenerDocumento(int id) {
        return this.documentoRepository.findById(id).get();
    }
}
