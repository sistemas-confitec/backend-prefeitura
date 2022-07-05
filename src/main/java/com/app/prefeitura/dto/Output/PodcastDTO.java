package com.app.prefeitura.dto.Output;

import com.app.prefeitura.entities.podcast.Enum.Status;

import java.io.Serializable;
import java.time.LocalDateTime;

public class PodcastDTO implements Serializable {

    private Long id;
    private String titulo;
    private String descricao;
    private LocalDateTime dataUpload;
    private Status status;

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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
