package com.app.prefeitura.repositories;

import com.app.prefeitura.dto.ServicoResponseDTO;
import com.app.prefeitura.entities.Servico;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Robson
 */
@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {

    public List<ServicoResponseDTO> findBySecretaria_Id(Long id);
    
}
