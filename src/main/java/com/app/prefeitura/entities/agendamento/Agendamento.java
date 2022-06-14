/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.prefeitura.entities.agendamento;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
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
@Table(name = "tb_agendamento")
public class Agendamento implements Serializable{
    
    private static final long serialVerionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "id_secretaria", referencedColumnName = "id")
    private Secretaria secretaria;
    
    @ManyToOne
    @JoinColumn(name="tipo_servico", referencedColumnName = "id")
    private TipoServico tipoServico;
    
    @Column(name="data")
    private LocalDate data;

    public Agendamento() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Secretaria getSecretaria() {
        return secretaria;
    }

    public void setSecretaria(Secretaria secretaria) {
        this.secretaria = secretaria;
    }

    public TipoServico getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(TipoServico tiposervico) {
        this.tipoServico = tiposervico;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
    
    
    
}
