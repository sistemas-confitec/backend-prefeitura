package com.app.prefeitura.dto.input;

import com.app.prefeitura.entities.postosSaude.UnidadeSaude;
import java.io.Serializable;

/**
 *
 * @author Robson
 */
public class UnidadeSaudeResponseDTO implements Serializable {

    // Posto
    private Long id;
    private String nome;
    // Endereco
    private String lougrado;
    private String numero;
    private String complemento;
    private String bairro;
    private String cep;
    
    private String longitude;
    private String latitude;

    public UnidadeSaudeResponseDTO() {
    }

    public UnidadeSaudeResponseDTO(Long id, String nome, String lougrado, String numero, String complemento, String bairro, String cep, String longitude, String latitude) {
        this.id = id;
        this.nome = nome;
        this.lougrado = lougrado;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cep = cep;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public UnidadeSaudeResponseDTO(UnidadeSaude entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.lougrado = entity.getEndereco().getLougrado();
        this.numero = entity.getEndereco().getNumero();
        this.complemento = entity.getEndereco().getComplemento();
        this.bairro = entity.getEndereco().getBairro();
        this.cep = entity.getEndereco().getCep();
        this.longitude = entity.getEndereco().getLougrado();
        this.latitude = entity.getEndereco().getLatitude();
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

    public String getLougrado() {
        return lougrado;
    }

    public void setLougrado(String lougrado) {
        this.lougrado = lougrado;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
    
    

}
