package com.app.prefeitura.repositories;

import com.app.prefeitura.entities.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Robson
 */
@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
    
}
