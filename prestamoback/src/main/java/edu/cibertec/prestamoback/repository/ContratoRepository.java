package edu.cibertec.prestamoback.repository;

import edu.cibertec.prestamoback.model.dao.ContratoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContratoRepository extends JpaRepository<ContratoEntity,Integer> {
}
