package com.app.prefeitura.entities.AvaliacaoAcoes;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "cliente")
public class AcoesPrefeitura implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    private String description;
    private Date date;

    
}
