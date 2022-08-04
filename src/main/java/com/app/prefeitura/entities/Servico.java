package com.app.prefeitura.entities;

import com.app.prefeitura.dto.ServicoDTO;
import com.app.prefeitura.dto.TipoServicoResponseDTO;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Robson
 */
@Entity
@Table(name = "tb_servico")
public class Servico implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;    
    
    @ManyToOne
    @JoinColumn(name="id_secretaria", referencedColumnName = "id")
    private Secretaria secretaria;

    public Servico() {
    }

    public Servico(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Servico(ServicoDTO dto) {
        this.nome = dto.getNome();
    }

    public Servico(TipoServicoResponseDTO dto) {
        this.nome = dto.getNome();
        this.descricao = dto.getDescricao();
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

    public Secretaria getSecretaria() {
        return secretaria;
    }

    public void setSecretaria(Secretaria idSecretaria) {
        this.secretaria = idSecretaria;
    }
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.id);
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
        final Servico other = (Servico) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
