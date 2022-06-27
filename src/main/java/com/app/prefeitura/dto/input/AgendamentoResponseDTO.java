package com.app.prefeitura.dto.input;

import com.app.prefeitura.entities.agendamento.Agendamento;
import com.app.prefeitura.entities.agendamento.Secretaria;
import com.app.prefeitura.entities.agendamento.TipoServico;
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
    private Long tipoServico;
    private LocalDate data;
    private LocalTime hora;

    public AgendamentoResponseDTO() {
    }

    public AgendamentoResponseDTO(Long id, Secretaria secretaria, TipoServico tipoServico, LocalDate data, LocalTime hora) {
        this.id = id;
        this.secretaria = secretaria.getId();
        this.tipoServico = tipoServico.getId();
        this.data = data;
        this.hora = hora;
    }
    
    public AgendamentoResponseDTO(Agendamento entity) {
        this.id = entity.getId();
        this.secretaria  = entity.getSecretaria().getId();
        this.tipoServico = entity.getTipoServico().getId();
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

    public Long getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(Long tipoServico) {
        this.tipoServico = tipoServico;
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