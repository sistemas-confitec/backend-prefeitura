package com.app.prefeitura.services;

import com.app.prefeitura.dto.AgendamentoResponseDTO;
import com.app.prefeitura.dto.AgendamentoDTO;
import com.app.prefeitura.entities.Agendamento;
import com.app.prefeitura.entities.Secretaria;
import com.app.prefeitura.entities.Servico;
import com.app.prefeitura.repositories.AgendamentoRepository;
import com.app.prefeitura.repositories.SecretariaRepository;
import com.app.prefeitura.services.exceptions.DatabaseException;
import com.app.prefeitura.services.exceptions.ResourceNotFoundException;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.app.prefeitura.repositories.ServicoRepository;

/**
 *
 * @author Robson
 */
@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository repository;

    @Autowired
    private SecretariaRepository repositorySecretaria;

    @Autowired
    private ServicoRepository repositoryServico;

    @Transactional(readOnly = true)
    public Page<AgendamentoDTO> findAllPaged(PageRequest pageResquest) {
        Page<Agendamento> list = repository.findAll(pageResquest);
        return list.map(AgendamentoDTO::new);
    }

    @Transactional(readOnly = true)
    public AgendamentoDTO findById(Long id) {
        Optional<Agendamento> obj = repository.findById(id);
        Agendamento entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new AgendamentoDTO(entity);
    }

    @Transactional
    public AgendamentoDTO insert(AgendamentoResponseDTO dto) {
        Agendamento entity = new Agendamento();

        Secretaria secretaria = repositorySecretaria.findById(dto.getSecretaria()).get();
        Servico tipoServico = repositoryServico.findById(dto.getServico()).get();

        entity.setSecretaria(secretaria);
        entity.setServico(tipoServico);
        entity.setData(dto.getData());
        entity.setHora(dto.getHora());
        entity = repository.save(entity);
        return new AgendamentoDTO(entity);
    }

    @Transactional
    public AgendamentoDTO update(Long id, AgendamentoResponseDTO dto) {
        try {
            Agendamento entity = repository.findById(id).get();

            Secretaria secretaria = repositorySecretaria.findById(dto.getSecretaria()).get();
            entity.setSecretaria(secretaria);

            Servico tipoServico = repositoryServico.findById(dto.getServico()).get();
            entity.setServico(tipoServico);

            entity.setData(dto.getData());
            entity.setHora(dto.getHora());

            entity = repository.save(entity);
            
            return new AgendamentoDTO(entity);
            
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not found" + id);
        }
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("If not found" + id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity violation");
        }
    }
    
    
    

}
