package edu.cibertec.prestamoback.service;

import edu.cibertec.prestamoback.model.dao.DocumentoEntity;

import java.util.List;

public interface DocumentoService {
    DocumentoEntity obtenerDocumento(int id);
    void insertarDocumento(DocumentoEntity documento);
    List<DocumentoEntity> listarDocumentos();
    DocumentoEntity obtenerDocumentoByNumber(String number);
}
