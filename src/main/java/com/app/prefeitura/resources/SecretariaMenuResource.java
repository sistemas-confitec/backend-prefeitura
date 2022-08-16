package com.app.prefeitura.resources;

import com.app.prefeitura.dto.SecretariaMenuDTO;
import com.app.prefeitura.dto.SecretariaMenuRequestDTO;
import com.app.prefeitura.entities.Menu;
import com.app.prefeitura.entities.Secretaria;
import com.app.prefeitura.entities.SecretariaMenu;
import com.app.prefeitura.services.SecretariaMenuService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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

    @GetMapping("/consultar/menus/{id}/secretaria")
    public ResponseEntity<List<Menu>> ListaMenusRestante(@PathVariable Long id) {
        List<Menu> list = servico.consultarMenuRestante(id);
        return ResponseEntity.ok().body(list);
    }
    
    @PostMapping
    public ResponseEntity<SecretariaMenuDTO> save(@RequestBody SecretariaMenuRequestDTO form){
        SecretariaMenu entity = servico.save(form);
        
        SecretariaMenuDTO dto = entity.toDTO();
        dto.adicionarMenu(entity.getMenu());
        
        return ResponseEntity.ok().body(dto);
    }

}
