package com.app.prefeitura.services;

import com.app.prefeitura.dto.SecretariaMenuDTO;
import com.app.prefeitura.dto.SecretariaMenuRequestDTO;
import com.app.prefeitura.entities.Menu;
import com.app.prefeitura.entities.Secretaria;
import com.app.prefeitura.entities.SecretariaMenu;
import com.app.prefeitura.repositories.MenuRepository;
import com.app.prefeitura.repositories.SecretariaMenuRepository;
import com.app.prefeitura.repositories.SecretariaRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Robson
 */
@Service
public class SecretariaMenuService {

    @Autowired
    private SecretariaMenuRepository repository;

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private SecretariaRepository secretariaRepository;

    public List<SecretariaMenuDTO> findBySecretariaId(Long id) {
        List<SecretariaMenu> list = repository.findBySecretariaId(id);
        List<SecretariaMenuDTO> listMenus = new ArrayList<>();
        SecretariaMenuDTO secretariaMenu = new SecretariaMenuDTO();

        secretariaMenu.setSecretaria(list.get(0).getSecretaria());
        list.forEach(obj -> secretariaMenu.adicionarMenu(obj.getMenu()));
        listMenus.add(secretariaMenu);

        return listMenus;
    }

    public List<Menu> consultarMenuRestante(Long id) {
        List<Menu> menus = menuRepository.consutarRestanteDosMenus(id);
        return menus;
    }

    public SecretariaMenu save(SecretariaMenuRequestDTO form) {

        List<Menu> menus = consultarMenuRestante(form.getSecretariaId());

        if (menus.stream().anyMatch(obj -> obj.getId() == form.getMenuId())) {

            Secretaria secretaria = secretariaRepository.findById(form.getSecretariaId()).get();
            Menu menu = menuRepository.findById(form.getMenuId()).get();

            SecretariaMenu entity = new SecretariaMenu();
            entity.setSecretaria(secretaria);
            entity.setMenu(menu);
            return repository.save(entity);
        }
        
        return null;
    }

}
