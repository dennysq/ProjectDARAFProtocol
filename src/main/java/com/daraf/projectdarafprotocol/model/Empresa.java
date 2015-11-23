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
    
    //Cuando se armen las cadenas asTexto y cuando se las desmonte se debe hacer en el mismo orden de los
    //atributos de esta clase
    
    private String RUC;//Longitud : 13              Ejemplo: 0000235681000
    private String nombre; //Longitud: 20           Ejemplo: AlterBios
    private String telefono;//Longitud: 10          Ejemplo: 032816955
    private String direccion;//Longitud: 50         Ejemplo: Latacunga, Calle 2 de Mayo y Tarqui 
    private String usuario; //Longitud fija: 10     Ejemplo:admin
    private String password; // Longitud fija: 10   Ejemplo:123456789
    
    //Todos los string de longitud fija usan StringUtils.rightPad y se rellenan con espacios en blanco
    //excepto si son IDs de la clase, esos usan StringUtils.leftPad y se rellenan con ceros
    
    //Solo manejamos la autentifacion de una empresa
    public Empresa(String a, String b, String c, String d, String e, String f)
    {
        RUC = a;
        nombre=b;
        telefono = c;
        direccion = d;
        usuario= e;
        password=f;
    }
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

    @Override
    public String toString() {
        return "Empresa{" + "RUC=" + RUC + ", nombre=" + nombre + ", telefono=" + telefono + ", direccion=" + direccion + ", usuario=" + usuario + ", password=" + password + '}';
    }
    
    
    
}
