/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daraf.projectdarafprotocol.model;

import com.daraf.projectdarafprotocol.Cuerpo;

/**
 *
 * @author ShipO
 */
public class Cliente {
    //Cuando se armen las cadenas asTexto y cuando se las desmonte se debe hacer en el mismo orden de los
    //atributos de esta clase
    
    private String identificacion;  //Longitud: 15    Ejemplo: 0503337909
    private String nombre;//Longitud: 30            Ejemplo: Daniela Valdez Ayora
    private String telefono;//Longitud: 10          Ejemplo: 032816955
    private String direccion;//Longitud: 50         Ejemplo: Latacunga, Calle 2 de Mayo y Tarqui 
    //Todos los string de longitud fija usan StringUtils.rightPad y se rellenan con espacios en blanco
    //excepto si son IDs de la clase, esos usan StringUtils.leftPad y se rellenan con ceros
    
    public Cliente(String identificacion,String nombre, String telefono, String direccion)
    {                 
            this.identificacion = identificacion;
            this.nombre = nombre;
            this.telefono = telefono;
            this.direccion = direccion;
                            
    }
    public Cliente()
    {
        
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
        return identificacion+Cuerpo.FIELD_SEPARATOR_CHAR+nombre + Cuerpo.FIELD_SEPARATOR_CHAR + telefono 
                + Cuerpo.FIELD_SEPARATOR_CHAR + direccion + Cuerpo.FIELD_SEPARATOR_CHAR ;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String asTexto() {
        return identificacion + "\t" + nombre + "\t" + telefono + "\t" + direccion ;
    }
}
