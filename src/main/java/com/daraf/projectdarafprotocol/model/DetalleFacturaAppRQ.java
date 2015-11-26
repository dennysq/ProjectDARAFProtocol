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
public class DetalleFacturaAppRQ {

    private String idProducto;

    private String cantidad;

    public DetalleFacturaAppRQ() {
    }

    public DetalleFacturaAppRQ(String idProducto, String cantidad) {
        this.idProducto = idProducto;
        this.cantidad = cantidad;
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

    @Override
    public String toString() {
        return idProducto + Cuerpo.FIELD_SEPARATOR_CHAR + cantidad + Cuerpo.FIELD_SEPARATOR_CHAR;
    }

}
