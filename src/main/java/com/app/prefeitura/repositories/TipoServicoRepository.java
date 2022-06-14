package com.app.prefeitura.repositories;

import com.app.prefeitura.entities.agendamento.TipoServico;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Robson
 */
public interface TipoServicoRepository extends JpaRepository<TipoServico, Long> {
    
}
