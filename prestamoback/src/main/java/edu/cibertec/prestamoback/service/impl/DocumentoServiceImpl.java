package edu.cibertec.prestamoback.service.impl;

import edu.cibertec.prestamoback.model.dao.ClienteEntity;
import edu.cibertec.prestamoback.model.dao.DocumentoEntity;
import edu.cibertec.prestamoback.repository.DocumentoRepository;
import edu.cibertec.prestamoback.service.DocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public void insertarDocumento(DocumentoEntity documento) {
        this.documentoRepository.save(documento);
    }

    @Override
    public List<DocumentoEntity> listarDocumentos() {
        return this.documentoRepository.findAll();
    }

    @Override
    public DocumentoEntity obtenerDocumentoByNumber(String number) {
        var lista=listarDocumentos();
        DocumentoEntity documento=null;
        for(DocumentoEntity documentos:lista){
            if(documentos.getNumero().toLowerCase().equals(number)) documento=documentos;
        }
        return documento;
    }
}
