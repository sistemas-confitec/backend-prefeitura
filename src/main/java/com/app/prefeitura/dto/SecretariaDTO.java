package com.app.prefeitura.dto;

import com.app.prefeitura.entities.agendamento.Secretaria;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Robson
 */
public class SecretariaDTO implements Serializable {

    private Long id;
    private String nome;

    public SecretariaDTO() {
    }

    public SecretariaDTO(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public SecretariaDTO(Secretaria secretaria) {
        this.id = secretaria.getId();
        this.nome = secretaria.getNome();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.id);
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
        final SecretariaDTO other = (SecretariaDTO) obj;
        return Objects.equals(this.id, other.id);
    }

}
