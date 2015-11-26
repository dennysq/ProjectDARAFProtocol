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
public class Producto {
    //Cuando se armen las cadenas asTexto y cuando se las desmonte se debe hacer en el mismo orden de los
    //atributos de esta clase

    private String id;//Longitud fija: 10           Ejemplo: 0000000025  *Se completa con ceros a la ixquierda
    private String nombre;//Longitud: 30            Ejemplo: Cuaderno Norma
    private String precio;//Longitud fija:12        Ejemplo: 1256.30 *Siempre debe tener 2 decimales
    private String cantidad;//Longitud: 10          Ejemplo: 15

    //Todos los string de longitud fija usan StringUtils.rightPad y se rellenan con espacios en blanco
    //excepto si son IDs de la clase, esos usan StringUtils.leftPad y se rellenan con ceros
    public Producto() {

    }

    public Producto(String id, String nombre, String precio, String cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return id + Cuerpo.FIELD_SEPARATOR_CHAR + nombre + Cuerpo.FIELD_SEPARATOR_CHAR + precio + Cuerpo.FIELD_SEPARATOR_CHAR + cantidad;
    }

}
