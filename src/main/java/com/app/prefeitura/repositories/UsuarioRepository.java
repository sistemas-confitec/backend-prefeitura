package com.app.prefeitura.repositories;

import com.app.prefeitura.entities.Usuario;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Robson
 */
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    
    Optional<Usuario> findByMatricula(String matricula);
    
}
