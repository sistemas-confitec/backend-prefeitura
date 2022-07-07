/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.app.prefeitura.repositories;

import com.app.prefeitura.entities.postosSaude.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Robson
 */
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    
}
