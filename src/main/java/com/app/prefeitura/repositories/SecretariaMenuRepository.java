package com.app.prefeitura.repositories;

import com.app.prefeitura.entities.SecretariaMenu;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Robson
 */
@Repository
public interface SecretariaMenuRepository extends JpaRepository<SecretariaMenu, Long> {

    public List<SecretariaMenu> findBySecretariaId(Long id);
    
}
