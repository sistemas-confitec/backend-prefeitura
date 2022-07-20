package com.app.prefeitura.dto;

import com.app.prefeitura.entities.Agendamento;
import com.app.prefeitura.entities.Secretaria;
import com.app.prefeitura.entities.Servico;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Robson
 */
public class AgendamentoDTO implements Serializable{

    private Long id;
    private Secretaria secretaria;
    private Servico servico;
    private LocalDate data;
    private LocalTime hora;

    public AgendamentoDTO() {
    }

    public AgendamentoDTO(Long id, Secretaria secretaria, Servico tipoServico, LocalDate data, LocalTime hora) {
        this.id = id;
        this.secretaria = secretaria;
        this.servico = tipoServico;
        this.data = data;
        this.hora = hora;
    }
    
    public AgendamentoDTO(Agendamento entity) {
        this.id = entity.getId();
        this.secretaria  = entity.getSecretaria();
        this.servico = entity.getServico();
        this.data = entity.getData();
        this.hora = entity.getHora();
    }

    public Long getId() {
        return id;
    }

    public Secretaria getSecretaria() {
        return secretaria;
    }

    public Servico getServico() {
        return servico;
    }

    public LocalDate getData() {
        return data;
    }

    public LocalTime getHora() {
        return hora;
    }

    
    
}
