package com.app.prefeitura.resources;

import com.app.prefeitura.dto.SecretariaMenuDTO;
import com.app.prefeitura.services.SecretariaMenuService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author Robson
 */
@RestController
@RequestMapping("/secretariaMenu")
public class SecretariaMenuResource {
    
    @Autowired
    private SecretariaMenuService servico;
    
    @GetMapping("/{id}")
    public ResponseEntity<List<SecretariaMenuDTO>> MenusDaSecretaria(@PathVariable Long id) {
        List<SecretariaMenuDTO> list = servico.findBySecretariaId(id);
        return ResponseEntity.ok().body(list);
    }

}
