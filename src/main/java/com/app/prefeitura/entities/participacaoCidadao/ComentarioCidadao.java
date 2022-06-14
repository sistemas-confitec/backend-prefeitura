package com.app.prefeitura.entities.participacaoCidadao;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Robson
 */
@Entity
@Table(name = "tb_comentario_cidadao")
public class ComentarioCidadao implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comentario;

    public ComentarioCidadao() {
    }

    public ComentarioCidadao(String comentario, String diretorioFoto) {
        this.comentario = comentario;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }    
    
}
