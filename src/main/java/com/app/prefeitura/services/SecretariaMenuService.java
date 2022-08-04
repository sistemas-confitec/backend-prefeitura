package com.app.prefeitura.services;

import com.app.prefeitura.dto.SecretariaMenuDTO;
import com.app.prefeitura.entities.SecretariaMenu;
import com.app.prefeitura.repositories.SecretariaMenuRepository;
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
    
    public List<SecretariaMenuDTO> findBySecretariaId(Long id){
        List<SecretariaMenu> list = repository.findBySecretariaId(id);
        List<SecretariaMenuDTO> listMenus = new ArrayList<>();
        SecretariaMenuDTO secretariaMenu = new SecretariaMenuDTO();
        
        secretariaMenu.setSecretaria(list.get(0).getSecretaria());
        list.forEach(obj -> secretariaMenu.adicionarMenu(obj.getMenu()));
        listMenus.add(secretariaMenu);
        
        return listMenus;
    }
}
