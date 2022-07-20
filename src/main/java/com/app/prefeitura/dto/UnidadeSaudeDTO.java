package com.app.prefeitura.dto;

import com.app.prefeitura.entities.Endereco;
import com.app.prefeitura.entities.UnidadeSaude;
import java.io.Serializable;

/**
 *
 * @author Robson
 */
public class UnidadeSaudeDTO implements Serializable {

    // Posto
    private Long id;
    private String nome;
    // Endereco
    private Endereco endereco;

    public UnidadeSaudeDTO() {
    }

    public UnidadeSaudeDTO(Long id, String nome, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
    }
    
    public UnidadeSaudeDTO(UnidadeSaude entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.endereco = entity.getEndereco();
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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

}
