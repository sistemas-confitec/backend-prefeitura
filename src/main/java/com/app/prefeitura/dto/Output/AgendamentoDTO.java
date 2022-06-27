package com.app.prefeitura.dto.output;

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
public class AgendamentoDTO implements Serializable{

    private Long id;
    private Secretaria secretaria;
    private TipoServico tipoServico;
    private LocalDate data;
    private LocalTime hora;

    public AgendamentoDTO() {
    }

    public AgendamentoDTO(Long id, Secretaria secretaria, TipoServico tipoServico, LocalDate data, LocalTime hora) {
        this.id = id;
        this.secretaria = secretaria;
        this.tipoServico = tipoServico;
        this.data = data;
        this.hora = hora;
    }
    
    public AgendamentoDTO(Agendamento entity) {
        this.id = entity.getId();
        this.secretaria  = entity.getSecretaria();
        this.tipoServico = entity.getTipoServico();
        this.data = entity.getData();
        this.hora = entity.getHora();
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

    public void setTipoServico(TipoServico tipoServico) {
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
