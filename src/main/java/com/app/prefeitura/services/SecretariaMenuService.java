package com.app.prefeitura.services;

import com.app.prefeitura.dto.SecretariaMenuResponseDTO;
import com.app.prefeitura.dto.SecretariaMenuRequestDTO;
import com.app.prefeitura.entities.Menu;
import com.app.prefeitura.entities.Secretaria;
import com.app.prefeitura.entities.SecretariaMenu;
import com.app.prefeitura.repositories.MenuRepository;
import com.app.prefeitura.repositories.SecretariaMenuRepository;
import com.app.prefeitura.repositories.SecretariaRepository;
import com.app.prefeitura.services.exceptions.DatabaseException;
import com.app.prefeitura.services.exceptions.ResourceNotFoundException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public List<SecretariaMenuResponseDTO> findBySecretariaId(Long id) {
        List<SecretariaMenu> list = repository.findBySecretariaId(id);
        List<SecretariaMenuResponseDTO> listMenus = new ArrayList<>();
        SecretariaMenuResponseDTO secretariaMenu = new SecretariaMenuResponseDTO();

        secretariaMenu.setSecretaria(list.get(0).getSecretaria());
        list.forEach(obj -> secretariaMenu.adicionarMenu(obj.getMenu()));
        listMenus.add(secretariaMenu);

        return listMenus;
    }

    public List<Menu> consultarMenuRestante(Long id) {
        List<Menu> menus = menuRepository.consutarRestanteDosMenus(id);
        return menus;
    }

    @Transactional
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
    
    @Transactional
    public void delete(Long idSecretaria, Long idMenu){
        try{
            Long id = repository.consultarMenuDaSecretaria(idSecretaria, idMenu);
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException("If not found " + idSecretaria);
        } catch (DataIntegrityViolationException e){
            throw new DatabaseException("Integrity violation");
        }
    }
    
}
