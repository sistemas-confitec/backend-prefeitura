package com.app.prefeitura.services;

import com.app.prefeitura.dto.UnidadeSaudeResponseDTO;
import com.app.prefeitura.dto.UnidadeSaudeDTO;
import com.app.prefeitura.entities.Endereco;
import com.app.prefeitura.entities.UnidadeSaude;
import com.app.prefeitura.repositories.EnderecoRepository;
import com.app.prefeitura.repositories.PostoSaudeRepository;
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
public class PostoSaudeService {

    @Autowired
    private PostoSaudeRepository repository;
    
    @Autowired
    private EnderecoRepository repositoryEndereco;

    public List<UnidadeSaude> findAll() {
        return repository.findAll();
    }

    public UnidadeSaude findById(Long id) {
        Optional<UnidadeSaude> op = repository.findById(id);
        UnidadeSaude entity = op.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return entity;
    }

    @Transactional
    public UnidadeSaudeDTO insert(UnidadeSaudeResponseDTO dto) {
        Endereco entityEndereco = new Endereco();
        entityEndereco.setLougrado(dto.getLougrado());
        entityEndereco.setNumero(dto.getNumero());
        entityEndereco.setComplemento(dto.getComplemento());
        entityEndereco.setBairro(dto.getBairro());
        entityEndereco.setCep(dto.getCep());
        entityEndereco.setLongitude(dto.getLongitude());
        entityEndereco.setLatitude(dto.getLatitude());
        repositoryEndereco.save(entityEndereco);

        UnidadeSaude entity = new UnidadeSaude();
        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
        entity.setEndereco(entityEndereco);
        repository.save(entity);
        return new UnidadeSaudeDTO(entity);
    }

    @Transactional
    public UnidadeSaudeDTO update(Long id, UnidadeSaudeResponseDTO dto) {
        try {
            UnidadeSaude entity = repository.findById(id).get();
            entity.setNome(dto.getNome());
            entity.getEndereco().setLougrado(dto.getLougrado());
            entity.getEndereco().setNumero(dto.getNumero());
            entity.getEndereco().setComplemento(dto.getComplemento());
            entity.getEndereco().setBairro(dto.getBairro());
            entity.getEndereco().setCep(dto.getCep());
            entity.getEndereco().setLongitude(dto.getLongitude());
            entity.getEndereco().setLatitude(dto.getLatitude());
            return new UnidadeSaudeDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        }
    }

    @Transactional
    public void delete(Long id) {
        try {
            UnidadeSaude entity = repository.findById(id).get();
            repositoryEndereco.deleteById(entity.getEndereco().getId());
            repository.deleteById(entity.getId());
            
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("If not found " + id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity violation");
        }
    }

}
