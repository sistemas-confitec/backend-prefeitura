/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.prefeitura.entities.participacaoCidadao;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Robson
 */
@Entity
@Table(name = "arquvos")
public class Arquivo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic(optional = false)
    @Column(name = "data_upload")
    private LocalDateTime dataUpload;

    @Basic(optional = false)
    @Column(name = "nome_original")
    private String nomeOriginal;
    //
    @Column(name = "nome_atual")
    private String nomeAtual;

    @Basic(optional = false)
    @Column(name = "localizacao")
    private String localizacao;

    private String url;

    private String extensao;

    private String descricao;

    private Integer height;

    private Integer width;

    public Arquivo() {
    }

    public Arquivo(Integer id, LocalDateTime dataUpload, String nomeOriginal, String nomeAtual, String url, String extensao, String descricao, Integer height, Integer width) {
        this.id = id;
        this.dataUpload = dataUpload;
        this.nomeOriginal = nomeOriginal;
        this.nomeAtual = nomeAtual;
        this.url = url;
        this.extensao = extensao;
        this.descricao = descricao;
        this.height = height;
        this.width = width;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDataUpload() {
        return dataUpload;
    }

    public void setDataUpload(LocalDateTime dataUpload) {
        this.dataUpload = dataUpload;
    }

    public String getNomeOriginal() {
        return nomeOriginal;
    }

    public void setNomeOriginal(String nomeOriginal) {
        this.nomeOriginal = nomeOriginal;
    }

    public String getNomeAtual() {
        return nomeAtual;
    }

    public void setNomeAtual(String nomeAtual) {
        this.nomeAtual = nomeAtual;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getExtensao() {
        return extensao;
    }

    public void setExtensao(String extensao) {
        this.extensao = extensao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    
}
