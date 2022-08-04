package com.app.prefeitura.services;

import com.app.prefeitura.dto.ServicoDTO;
import com.app.prefeitura.dto.TipoServicoResponseDTO;
import com.app.prefeitura.entities.Secretaria;
import com.app.prefeitura.entities.Servico;
import com.app.prefeitura.repositories.SecretariaRepository;
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
import com.app.prefeitura.repositories.ServicoRepository;

/**
 *
 * @author Robson
 */
@Service
public class ServicoService {

    @Autowired
    private ServicoRepository repository;

    @Autowired
    private SecretariaRepository repositorySecretaria;

    public List<Servico> findAll() {
        return repository.findAll();
    }

    public Servico findById(Long id) {
        Optional<Servico> obj = repository.findById(id);
        Servico entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return entity;
    }
    
    public List<ServicoDTO> findBySecretaria(Long id) {
        return repository.findBySecretaria_Id(id);
    }

    @Transactional
    public ServicoDTO insert(TipoServicoResponseDTO dto) {
        Servico entity = new Servico(dto);
        Secretaria secretaria = repositorySecretaria.findById(dto.getSecretaria()).get();
        entity.setSecretaria(secretaria);
        repository.save(entity);
        return new ServicoDTO(entity);
    }

    @Transactional
    public ServicoDTO update(Long id, TipoServicoResponseDTO tipoServico) {
        try {
            Servico entity = repository.findById(id).get();
            entity.setNome(tipoServico.getNome());
            entity.setDescricao(tipoServico.getDescricao());
            
            Secretaria secretaria = repositorySecretaria.findById(tipoServico.getSecretaria()).get();
            entity.setSecretaria(secretaria);
            repository.save(entity);
            return new ServicoDTO(entity);
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
