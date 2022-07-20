package com.app.prefeitura.repositories;

import com.app.prefeitura.entities.Secretaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Robson
 */
@Repository
public interface SecretariaRepository extends JpaRepository<Secretaria, Long> {
    
}
