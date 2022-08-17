package com.app.prefeitura.services;

import com.app.prefeitura.dto.SecretariaResponseDTO;
import com.app.prefeitura.dto.ServicoResponseDTO;
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

/**
 *
 * @author Robson
 */
@Service
public class SecretariaService {

    @Autowired
    private SecretariaRepository repository;

    public List<Secretaria> findAll() {
        return repository.findAll();
    }

    public Secretaria findById(Long id) {
        Optional<Secretaria> obj = repository.findById(id);
        Secretaria entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return entity;
    }

    

    @Transactional
    public SecretariaResponseDTO insert(SecretariaResponseDTO secretaria) {
        Secretaria entity = new Secretaria(secretaria);
        repository.save(entity);
        return new SecretariaResponseDTO(entity);
    }

    @Transactional
    public SecretariaResponseDTO update(Long id, SecretariaResponseDTO secretaria) {
        try {
            Secretaria entity = repository.findById(id).get();
            entity.setNome(secretaria.getNome());
            entity.setDescricao(secretaria.getDescricao());
            repository.save(entity);
            return new SecretariaResponseDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        }
    }

    @Transactional
    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("If not found " + id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity violation");
        }
    }
}
