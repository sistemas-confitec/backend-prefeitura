package com.app.prefeitura.dto;

import com.app.prefeitura.entities.SecretariaMenu;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

/**
 *
 * @author Robson
 */
public class SecretariaMenuRequestDTO {

    private Long secretariaId;
    private Long menuId;

    public SecretariaMenuRequestDTO() {
    }

    public SecretariaMenuRequestDTO(Long secretariaId, Long menuId) {
        this.secretariaId = secretariaId;
        this.menuId = menuId;
    }

    public Long getSecretariaId() {
        return secretariaId;
    }

    public void setSecretariaId(Long secretariaId) {
        this.secretariaId = secretariaId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public SecretariaMenu toEntity(SecretariaMenuRequestDTO form) {
        ModelMapper mapper = new ModelMapper();
        mapper.addMappings( new PropertyMap<SecretariaMenuRequestDTO, SecretariaMenu>() {
            @Override
            protected void configure() {
            Long menu = source.getMenuId(); map().getMenu().setId(menu);
            Long secretaria = source.getSecretariaId(); map().getSecretaria().setId(secretaria);
            }
        });
        
        return mapper.map(this, SecretariaMenu.class);
    }

}
