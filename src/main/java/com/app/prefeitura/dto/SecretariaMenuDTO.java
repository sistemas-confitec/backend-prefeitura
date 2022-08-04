/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.prefeitura.dto;

import com.app.prefeitura.entities.Menu;
import com.app.prefeitura.entities.Secretaria;
import com.app.prefeitura.entities.SecretariaMenu;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Robson
 */
public class SecretariaMenuDTO {

    private Secretaria secretaria;
    private List<Menu> menus = new ArrayList<>();

    public SecretariaMenuDTO() {
    }
    
    public SecretariaMenuDTO(Secretaria secretaria, List<Menu> menus) {
        this.secretaria = secretaria;
        this.menus = menus;
    }

    public SecretariaMenuDTO(SecretariaMenu menu) {
        this.secretaria = menu.getSecretaria();
        this.menus.add(menu.getMenu());
    }
    
    public void adicionarMenu(Menu menu){
        menus.add(menu);
    }

    public Secretaria getSecretaria() {
        return secretaria;
    }

    public void setSecretaria(Secretaria secretaria) {
        this.secretaria = secretaria;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

}
