package com.app.prefeitura.services;

import com.app.prefeitura.entities.Menu;
import com.app.prefeitura.repositories.MenuRepository;
import com.app.prefeitura.services.exceptions.ResourceNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Robson
 */
@Service
public class MenuService {
    
    @Autowired
    private MenuRepository repository;
    
    
    public List<Menu> findAll(){
        return repository.findAll();
    }
    
    public Menu findById(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
    }
}
