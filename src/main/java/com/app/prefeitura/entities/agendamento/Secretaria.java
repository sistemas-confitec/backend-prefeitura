/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.prefeitura.entities.agendamento;

import com.app.prefeitura.dto.SecretariaDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Robson
 */
@Entity
@Table(name="tb_secretaria")
public class Secretaria implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    
    @JsonIgnore
    @OneToMany(mappedBy = "secretaria")
    private List<Agendamento> agendamentos = new ArrayList<>();
    
    public Secretaria() {
    }

    public Secretaria(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    
    public Secretaria(SecretariaDTO dto) {
        this.nome = dto.getNome();
    }    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Agendamento> getAgendamentos() {
        return agendamentos;
    }

    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Secretaria other = (Secretaria) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
