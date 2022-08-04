package com.app.prefeitura.resources;

import com.app.prefeitura.entities.Menu;
import com.app.prefeitura.services.MenuService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Robson
 */
@RestController
@RequestMapping("/menu")
public class MenuResource {
    
    @Autowired
    private MenuService service;
    
    @GetMapping
    public ResponseEntity<List<Menu>> findAll(){
        List<Menu> menus = service.findAll();
        return ResponseEntity.ok().body(menus);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Menu> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(service.findById(id));
    }

}
