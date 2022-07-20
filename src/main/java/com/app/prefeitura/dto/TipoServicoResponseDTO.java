package com.app.prefeitura.dto;

import com.app.prefeitura.entities.Servico;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Robson
 */
public class TipoServicoResponseDTO implements Serializable {

    private Long id;
    private String nome;
    private String descricao;
    private Long idSecretaria;
    
    public TipoServicoResponseDTO() {
    }

    public TipoServicoResponseDTO(String nome, String descricao, Long idSecretaria) {
        this.nome = nome;
        this.descricao = descricao;
        this.idSecretaria = idSecretaria;
    }

    public TipoServicoResponseDTO(Servico entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.idSecretaria = entity.getIdSecretaria().getId();
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getIdSecretaria() {
        return idSecretaria;
    }

    public void setIdSecretaria(Long idSecretaria) {
        this.idSecretaria = idSecretaria;
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
        final TipoServicoResponseDTO other = (TipoServicoResponseDTO) obj;
        return Objects.equals(this.id, other.id);
    }

}
