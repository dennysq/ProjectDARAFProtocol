/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daraf.projectdarafprotocol.model;

import com.daraf.projectdarafprotocol.Cuerpo;
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
    public Empresa(String a, String b, String c, String d, String e, String f) {
        RUC = a;
        nombre = b;
        telefono = c;
        direccion = d;
        usuario = e;
        password = f;
    }

    public Empresa() {

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
        this.usuario = usuario;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return RUC + Cuerpo.FIELD_SEPARATOR_CHAR + nombre + Cuerpo.FIELD_SEPARATOR_CHAR + telefono + Cuerpo.FIELD_SEPARATOR_CHAR + direccion + Cuerpo.FIELD_SEPARATOR_CHAR + usuario + Cuerpo.FIELD_SEPARATOR_CHAR + password + Cuerpo.FIELD_SEPARATOR_CHAR;
    }

    public String getRUC() {
        return RUC;
    }

    public void setRUC(String RUC) {
        this.RUC = RUC;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    
}
