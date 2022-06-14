package com.app.prefeitura.resources;

import com.app.prefeitura.dto.ComentarioCidadaoDTO;
import com.app.prefeitura.entities.participacaoCidadao.ComentarioCidadao;
import com.app.prefeitura.services.ComentarioCidadaoService;
import java.io.IOException;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author Robson
 */
@RestController
@RequestMapping(value = "/comentarios")
public class ComentarioCidadaoResouce {

    @Autowired
    private ComentarioCidadaoService service;

    @GetMapping
    public ResponseEntity<List<ComentarioCidadao>> findAll() {
        List<ComentarioCidadao> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<ComentarioCidadaoDTO> insert(@RequestBody ComentarioCidadaoDTO comentario) {
        ComentarioCidadao entity = service.insert(comentario);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(entity.getId()).toUri();
        return ResponseEntity.created(uri).body(new ComentarioCidadaoDTO(entity));
    }

    @PostMapping("/upload")
    public void upload(@RequestParam MultipartFile foto) throws IOException {
        service.upload(foto);
    }
}
