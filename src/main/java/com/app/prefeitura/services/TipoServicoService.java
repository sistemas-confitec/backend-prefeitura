package com.app.prefeitura.services;

import com.app.prefeitura.dto.TipoServicoDTO;
import com.app.prefeitura.entities.agendamento.TipoServico;
import com.app.prefeitura.repositories.TipoServicoRepository;
import com.app.prefeitura.services.exceptions.DatabaseException;
import com.app.prefeitura.services.exceptions.ResourceNotFoundException;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Robson
 */
@Service
public class TipoServicoService {

    @Autowired
    private TipoServicoRepository repository;

    public List<TipoServico> findAll() {
        return repository.findAll();
    }

    public TipoServico findById(Long id) {
        Optional<TipoServico> obj = repository.findById(id);
        TipoServico entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return entity;
    }

    @Transactional
    public TipoServicoDTO insert(TipoServicoDTO tipoServico) {
        TipoServico entity = new TipoServico(tipoServico);
        repository.save(entity);
        return new TipoServicoDTO(entity);
    }

    @Transactional
    public TipoServicoDTO update(Long id, TipoServicoDTO tipoServico) {
        try {
            TipoServico entity = repository.getById(id);
            entity.setNome(tipoServico.getNome());
            repository.save(entity);
            return new TipoServicoDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        }
    }
    
    @Transactional
    public void delete(Long id){
        try{
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException("If not found " + id);
        } catch (DataIntegrityViolationException e){
            throw new DatabaseException("Integrity violation");
        }
    }
}
