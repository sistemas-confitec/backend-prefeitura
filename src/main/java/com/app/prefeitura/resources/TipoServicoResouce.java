/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.prefeitura.resources;

import com.app.prefeitura.dto.TipoServicoDTO;
import com.app.prefeitura.entities.agendamento.TipoServico;
import com.app.prefeitura.services.TipoServicoService;
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
@RequestMapping(value = "/tipoServicos")
public class TipoServicoResouce {
    
    @Autowired
    private TipoServicoService service;
    
    @GetMapping
    public ResponseEntity<List<TipoServico>> findAll() {
        List<TipoServico> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<TipoServico> findById(@PathVariable Long id){
        TipoServico entity = service.findById(id);
        return ResponseEntity.ok().body(entity);
    }
    
    @PostMapping()
    public ResponseEntity<TipoServicoDTO> insert(@RequestBody TipoServicoDTO dto){
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
    
    @PutMapping(value = "/{id}")
    public ResponseEntity<TipoServicoDTO> update(@PathVariable Long id, @RequestBody TipoServicoDTO dto){
        dto = service.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<TipoServicoDTO> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}
