/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daraf.projectdarafprotocol.model;

import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Alejandra Ponce
 */
public class Empresa {
    
    private String nombre; //Longitud: 20           Ejemplo:AlterBios
    private String usuario; //Longitud fija: 10     Ejemplo:admin
    private String password; // Longitud fija: 10   Ejemplo:123456789
    
    //Todos los string de longitud fija usan StringUtils.rightPad y se rellenan con espacios en blanco
    //excepto si son IDs de la clase, esos usan StringUtils.leftPad y se rellenan con ceros
    
    //Solo manejamos la autentifacion de una empresa

    public String getNombre() {
        return nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setUsuario(String usuario) {
        this.usuario = StringUtils.rightPad(usuario, 10, " ");
    }

    public void setPassword(String password) {
        this.password = StringUtils.rightPad(password, 10, " ");
    }
    
    
    
}
