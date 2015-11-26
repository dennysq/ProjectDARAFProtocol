/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daraf.projectdarafprotocol.model;

/**
 *
 * @author ShipO
 */
public class Cliente {
    //Cuando se armen las cadenas asTexto y cuando se las desmonte se debe hacer en el mismo orden de los
    //atributos de esta clase

    private String id;   //Longitud fija: 10        Ejemplo: 0000000025  *Se completa con ceros a la ixquierda
    private String nombre;//Longitud: 30            Ejemplo: Daniela Valdez Ayora
    private String telefono;//Longitud: 10          Ejemplo: 032816955
    private String direccion;//Longitud: 50         Ejemplo: Latacunga, Calle 2 de Mayo y Tarqui 
    private String identificacion;//Longitud: 15    Ejemplo: 0503337909

    //Todos los string de longitud fija usan StringUtils.rightPad y se rellenan con espacios en blanco
    //excepto si son IDs de la clase, esos usan StringUtils.leftPad y se rellenan con ceros
    public Cliente() {
    }

    public Cliente(String id, String nombre, String telefono, String direccion, String identificacion) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.identificacion = identificacion;
    }

    public String getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public String getIdentificacion() {
        return this.identificacion;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return id + "\t" + nombre + "\t" + telefono + "\t" + direccion + "\t" + identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String asTexto() {
        return id.toString() + "\t" + nombre + "\t" + telefono + "\t" + direccion + "\t" + identificacion;
    }
}
