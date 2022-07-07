package com.app.prefeitura.repositories;

import com.app.prefeitura.entities.postosSaude.UnidadeSaude;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Robson
 */
public interface PostoSaudeRepository extends JpaRepository<UnidadeSaude, Long> {
    
}
