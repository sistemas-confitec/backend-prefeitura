package com.app.prefeitura.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.prefeitura.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

}
