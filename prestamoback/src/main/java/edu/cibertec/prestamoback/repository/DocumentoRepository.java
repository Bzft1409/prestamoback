package edu.cibertec.prestamoback.repository;

import edu.cibertec.prestamoback.model.dao.DocumentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentoRepository extends JpaRepository<DocumentoEntity,Integer> {
}
