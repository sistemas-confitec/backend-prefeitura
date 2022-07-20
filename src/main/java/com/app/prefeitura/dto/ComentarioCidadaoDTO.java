package com.app.prefeitura.dto;

import com.app.prefeitura.entities.ComentarioCidadao;
import java.io.Serializable;

/**
 *
 * @author Robson
 */
public class ComentarioCidadaoDTO implements Serializable {
    
    private String comentario;
    
    private FotoDTO foto;

    public ComentarioCidadaoDTO() {
    }

    public ComentarioCidadaoDTO(ComentarioCidadao comentario) {
        this.comentario = comentario.getComentario();
    }
    
    public String getComentario() {
        return comentario;
    }

    

}
