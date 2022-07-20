/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.app.prefeitura.repositories;

import com.app.prefeitura.entities.ComentarioCidadao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Robson
 */
@Repository
public interface ComentarioCidadaoRepository extends CrudRepository<ComentarioCidadao, Long> {
    
}
