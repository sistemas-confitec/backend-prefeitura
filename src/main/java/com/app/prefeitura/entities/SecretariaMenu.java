package com.app.prefeitura.entities;

import com.app.prefeitura.dto.SecretariaMenuResponseDTO;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.modelmapper.ModelMapper;

/**
 *
 * @author Robson
 */
@Entity
@Table(name = "secretaria_menu")
public class SecretariaMenu implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @ManyToOne
    @JoinColumn(name = "id_secretaria", referencedColumnName = "id")
    private Secretaria secretaria;
    
    @ManyToOne
    @JoinColumn(name = "id_menu", referencedColumnName = "id")
    private Menu menu;

    public SecretariaMenu() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Secretaria getSecretaria() {
        return secretaria;
    }

    public void setSecretaria(Secretaria secretaria) {
        this.secretaria = secretaria;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final SecretariaMenu other = (SecretariaMenu) obj;
        return this.id == other.id;
    }
    
    public SecretariaMenuResponseDTO toDTO(){
        ModelMapper mapper = new ModelMapper();
        return mapper.map(this, SecretariaMenuResponseDTO.class);
    }
    
}
