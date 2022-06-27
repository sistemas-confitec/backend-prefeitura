/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.prefeitura.resources;

import com.app.prefeitura.dto.output.SecretariaDTO;
import com.app.prefeitura.entities.agendamento.Secretaria;
import com.app.prefeitura.services.SecretariaService;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author Robson
 */
@RestController
@RequestMapping(value = "/secretarias")
public class SecretariaResouce {

    @Autowired
    private SecretariaService service;

    @GetMapping
    public ResponseEntity<List<Secretaria>> findAll(){
           List<Secretaria> list = service.findAll();
           return ResponseEntity.ok().body(list);
    }
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<Secretaria> findById(@PathVariable Long id) {
        Secretaria entity = service.findById(id);
        return ResponseEntity.ok().body(entity);
    }
    
    @PostMapping()
    public ResponseEntity<SecretariaDTO> insert(@RequestBody SecretariaDTO dto){
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
    
        return ResponseEntity.created(uri).body(dto);
    }
    
    @PutMapping(value = "/{id}")
    public ResponseEntity<SecretariaDTO> update(@PathVariable Long id, @RequestBody SecretariaDTO dto) {
        dto = service.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }
    
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<SecretariaDTO> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}
