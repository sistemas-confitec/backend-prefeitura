package com.app.prefeitura.repositories;

import com.app.prefeitura.entities.Menu;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Robson
 */
@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {

    // WHERE m.id  <> ( SELECT  sm.ID_MENU FROM  SECRETARIA_MENU as sm where sm.id =:id)
    //<> ( SELECT sm.id_menu FROM secretaria_menu sm where sm.id_secretaria =:id)
    @Query(value = "SELECT * FROM menu m "
            + "WHERE m.id not in ( "
            + "SELECT sm.id_menu FROM secretaria_menu sm where sm.id_secretaria =:id)",
            nativeQuery = true)
    public List<Menu> consutarRestanteDosMenus(Long id);

}
