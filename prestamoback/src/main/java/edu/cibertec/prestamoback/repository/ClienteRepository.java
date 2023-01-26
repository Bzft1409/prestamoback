package edu.cibertec.prestamoback.repository;

import edu.cibertec.prestamoback.model.dao.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity,Integer> {
}
