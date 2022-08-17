 package com.app.prefeitura.dto;

import com.app.prefeitura.entities.Secretaria;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Robson
 */
public class SecretariaResponseDTO implements Serializable {

    private Long id;
    private String nome;
    private String descricao;

    public SecretariaResponseDTO() {
    }

    public SecretariaResponseDTO(Long id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    public SecretariaResponseDTO(Secretaria secretaria) {
        this.id = secretaria.getId();
        this.nome = secretaria.getNome();
        this.descricao =  secretaria.getDescricao();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
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
        final SecretariaResponseDTO other = (SecretariaResponseDTO) obj;
        return Objects.equals(this.id, other.id);
    }

}
