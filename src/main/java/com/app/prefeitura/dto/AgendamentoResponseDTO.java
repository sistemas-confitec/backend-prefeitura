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
public class AgendamentoResponseDTO implements Serializable{

    private Long id;
    private Long secretaria;
    private Long servico;
    private LocalDate data;
    private LocalTime hora;

    public AgendamentoResponseDTO() {
    }

    public AgendamentoResponseDTO(Long id, Secretaria secretaria, Servico tipoServico, LocalDate data, LocalTime hora) {
        this.id = id;
        this.secretaria = secretaria.getId();
        this.servico = tipoServico.getId();
        this.data = data;
        this.hora = hora;
    }
    
    public AgendamentoResponseDTO(Agendamento entity) {
        this.id = entity.getId();
        this.secretaria  = entity.getSecretaria().getId();
        this.servico = entity.getServico().getId();
        this.data = entity.getData();
        this.hora = entity.getHora();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSecretaria() {
        return secretaria;
    }

    public void setSecretaria(Long secretaria) {
        this.secretaria = secretaria;
    }

    public Long getServico() {
        return servico;
    }

    public void setServico(Long tipoServico) {
        this.servico = tipoServico;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }
    
}
