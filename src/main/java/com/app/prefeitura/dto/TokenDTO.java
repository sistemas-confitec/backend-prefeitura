/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.prefeitura.dto;

/**
 *
 * @author Robson
 */
public class TokenDTO {
    
    private String token;
    private String tipo;

    public TokenDTO(String token, String tipo) {
        this.token = token;
        this.tipo = tipo;
    }

    public String getToken() {
        return token;
    }

    public String getTipo() {
        return tipo;
    }
    
}
