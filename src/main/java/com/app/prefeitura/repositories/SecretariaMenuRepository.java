package com.app.prefeitura.repositories;

import com.app.prefeitura.entities.SecretariaMenu;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Robson
 */
@Repository
public interface SecretariaMenuRepository extends JpaRepository<SecretariaMenu, Long> {

    public List<SecretariaMenu> findBySecretariaId(Long id);

    @Query(nativeQuery = true,
            value = "SELECT o.id FROM secretaria_menu o "
                    + "WHERE o.id_secretaria =:idSecretaria and o.id_menu=:idMenu")
    public Long consultarMenuDaSecretaria(Long idSecretaria, Long idMenu);
    
    
    
}
