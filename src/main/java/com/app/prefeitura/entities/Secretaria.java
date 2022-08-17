package com.app.prefeitura.entities;

import com.app.prefeitura.dto.SecretariaResponseDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Robson
 */
@Entity
@Table(name="secretaria")
public class Secretaria implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    
    @JsonIgnore
    @OneToMany(mappedBy = "secretaria")
    private List<Agendamento> agendamentos = new ArrayList<>();
    
    
    @JsonIgnore
    @OneToMany(mappedBy = "secretaria")
    private List<Servico> servicos = new ArrayList<>();
    
    
    @OneToMany(mappedBy = "secretaria")
    private List<SecretariaMenu> menuDeSecretaria = new ArrayList<>();
    
    
    public Secretaria() {
    }

    public Secretaria(Long id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }
    
    public Secretaria(SecretariaResponseDTO dto) {
        this.nome = dto.getNome();
        this.descricao = dto.getDescricao();
    }    
    
    public void adicionarMenus(SecretariaMenu menu){
        menu.setSecretaria(this);
        this.menuDeSecretaria.add(menu);
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
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Agendamento> getAgendamentos() {
        return agendamentos;
    }

    public List<Servico> getServicos() {
        return servicos;
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
