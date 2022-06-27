package com.app.prefeitura.dto.output;

import com.app.prefeitura.entities.agendamento.TipoServico;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Robson
 */
public class TipoServicoDTO implements Serializable {

    private Long id;
    private String nome;

    public TipoServicoDTO() {
    }

    public TipoServicoDTO(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public TipoServicoDTO(TipoServico tipoServico) {
        this.id = tipoServico.getId();
        this.nome = tipoServico.getNome();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TipoServicoDTO other = (TipoServicoDTO) obj;
        return Objects.equals(this.id, other.id);
    }

}
