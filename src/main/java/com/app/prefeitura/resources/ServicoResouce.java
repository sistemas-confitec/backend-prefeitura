package com.app.prefeitura.resources;

import com.app.prefeitura.dto.ServicoResponseDTO;
import com.app.prefeitura.dto.TipoServicoResponseDTO;
import com.app.prefeitura.entities.Servico;
import com.app.prefeitura.services.ServicoService;
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
@RequestMapping(value = "/servicos")
public class ServicoResouce {
    
    @Autowired
    private ServicoService service;
    
    @GetMapping
    public ResponseEntity<List<Servico>> findAll() {
        List<Servico> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<Servico> findById(@PathVariable Long id){
        Servico entity = service.findById(id);
        return ResponseEntity.ok().body(entity);
    }
    
    @GetMapping(value = "/secretaria/{id}")
    public ResponseEntity<List<ServicoResponseDTO>> findBySecretaria(@PathVariable Long id){
        List<ServicoResponseDTO> list = service.findBySecretaria(id);
        return ResponseEntity.ok().body(list);
    }
    
    @PostMapping()
    public ResponseEntity<ServicoResponseDTO> insert(@RequestBody TipoServicoResponseDTO dtoResponse){
        ServicoResponseDTO dto = service.insert(dtoResponse);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
    
    @PutMapping(value = "/{id}")
    public ResponseEntity<ServicoResponseDTO> update(@PathVariable Long id, @RequestBody TipoServicoResponseDTO dtoResponse){
        ServicoResponseDTO dto = service.update(id, dtoResponse);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ServicoResponseDTO> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    
    
    
}
