package com.app.prefeitura.repositories;

import com.app.prefeitura.entities.Arquivo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Robson
 */
public interface ArquivoRepository extends JpaRepository<Arquivo, Long> {
    
}
