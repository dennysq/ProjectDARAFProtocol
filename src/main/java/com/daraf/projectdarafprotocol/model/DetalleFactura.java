/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daraf.projectdarafprotocol.model;

import com.daraf.projectdarafprotocol.Cuerpo;

/**
 *
 * @author Dennys
 */
public class DetalleFactura {

    private String idProducto;
    private String precio;
    private String nombre;
    private String cantidad;

    public DetalleFactura() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return idProducto + Cuerpo.FIELD_SEPARATOR_CHAR + nombre + Cuerpo.FIELD_SEPARATOR_CHAR + precio + Cuerpo.FIELD_SEPARATOR_CHAR + cantidad + Cuerpo.FIELD_SEPARATOR_CHAR;
    }

}
