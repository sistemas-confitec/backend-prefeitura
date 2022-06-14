package com.app.prefeitura.dto;

import com.app.prefeitura.entities.agendamento.Agendamento;
import com.app.prefeitura.entities.agendamento.Secretaria;
import com.app.prefeitura.entities.agendamento.TipoServico;
import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author Robson
 */
public class AgendamentoDTO implements Serializable{

    private Long id;
    private Secretaria secretaria;
    private TipoServico tipoServico;
    private LocalDate data;

    public AgendamentoDTO() {
    }

    public AgendamentoDTO(Long id, Secretaria secretaria, TipoServico tipoServico, LocalDate data) {
        this.id = id;
        this.secretaria.setId(secretaria.getId());
        this.tipoServico.setId(tipoServico.getId());
        this.data = data;
    }
    
    public AgendamentoDTO(Agendamento entity) {
        this.id = entity.getId();
        this.secretaria  = entity.getSecretaria();
        this.tipoServico = entity.getTipoServico();
        this.data = entity.getData();
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
    
    
    
    
}
