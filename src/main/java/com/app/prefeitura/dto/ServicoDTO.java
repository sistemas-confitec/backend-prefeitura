package com.app.prefeitura.dto;

import com.app.prefeitura.entities.Secretaria;
import com.app.prefeitura.entities.Servico;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Robson
 */
public class ServicoDTO implements Serializable {

    private Long id;
    private String nome;
    private String descricao;
    private Long idSecretaria;
    
    public ServicoDTO() {
    }

    public ServicoDTO(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public ServicoDTO(Servico entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.descricao = entity.getDescricao();
        this.idSecretaria = entity.getIdSecretaria().getId();
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

    public Long getIdSecretaria() {
        return idSecretaria;
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
        final ServicoDTO other = (ServicoDTO) obj;
        return Objects.equals(this.id, other.id);
    }

}
