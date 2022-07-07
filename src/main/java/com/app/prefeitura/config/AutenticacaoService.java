package com.app.prefeitura.config;

import com.app.prefeitura.entities.admin.Usuario;
import com.app.prefeitura.repositories.UsuarioRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Robson
 */
@Service
public class AutenticacaoService implements UserDetailsService{
    
    @Autowired
    private UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String matricula) throws UsernameNotFoundException {
        Optional<Usuario> usuario = repository.findByMatricula(matricula);
        if (usuario.isPresent()) {
            return usuario.get();
        }
        throw new UsernameNotFoundException("Dados inválidos");
    }    
    
}
