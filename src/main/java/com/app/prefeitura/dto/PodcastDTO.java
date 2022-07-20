package com.app.prefeitura.dto;

import com.app.prefeitura.entities.enuns.StatusPodcast;

import java.io.Serializable;
import java.time.LocalDateTime;

public class PodcastDTO implements Serializable {

    private Long id;
    private String titulo;
    private String descricao;
    private LocalDateTime dataUpload;
    private StatusPodcast status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataUpload() {
        return dataUpload;
    }

    public void setDataUpload(LocalDateTime dataUpload) {
        this.dataUpload = dataUpload;
    }

    public StatusPodcast getStatus() {
        return status;
    }

    public void setStatus(StatusPodcast status) {
        this.status = status;
    }
}
