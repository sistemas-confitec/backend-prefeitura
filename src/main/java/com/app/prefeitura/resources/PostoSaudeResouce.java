package com.app.prefeitura.resources;

import com.app.prefeitura.dto.UnidadeSaudeRequestDTO;
import com.app.prefeitura.dto.UnidadeSaudeResponseDTO;
import com.app.prefeitura.entities.UnidadeSaude;
import com.app.prefeitura.services.PostoSaudeService;
import java.io.Serializable;
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
@RequestMapping(value = "/unidadesDeSaude")
public class PostoSaudeResouce implements Serializable {

    @Autowired
    private PostoSaudeService service;

    @GetMapping
    public ResponseEntity<List<UnidadeSaude>> findAll() {
        List<UnidadeSaude> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UnidadeSaude> findById(@PathVariable Long id) {
        UnidadeSaude entity = service.findById(id);
        return ResponseEntity.ok().body(entity);
    }

    @PostMapping
    public ResponseEntity<UnidadeSaudeResponseDTO> insert(@RequestBody UnidadeSaudeRequestDTO dtoResponse) {
        UnidadeSaudeResponseDTO dto = service.insert(dtoResponse);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();

        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UnidadeSaudeResponseDTO> update(@PathVariable Long id, @RequestBody UnidadeSaudeRequestDTO dtoResponse) {
        UnidadeSaudeResponseDTO dto = service.update(id, dtoResponse);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<UnidadeSaudeResponseDTO> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
