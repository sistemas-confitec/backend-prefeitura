package com.app.prefeitura.repositories;

import com.app.prefeitura.dto.ServicoDTO;
import com.app.prefeitura.entities.Servico;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Robson
 */
public interface ServicoRepository extends JpaRepository<Servico, Long> {

    public List<ServicoDTO> findByIdSecretaria_Id(Long id);
    
}
