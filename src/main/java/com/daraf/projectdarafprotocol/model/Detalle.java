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
public class Detalle {
    //Cuando se armen las cadenas asTexto y cuando se las desmonte se debe hacer en el mismo orden de los
    //atributos de esta clase

    private String id; //Longitud fija: 10              Ejemplo: 0000000025  *Se completa con ceros a la ixquierda
    private String idFactura;//Longitud fija: 10        Ejemplo: 0000000788  *Se completa con ceros a la ixquierda  
    private String idProducto;
    private String nombreProducto;//Longitud: 30        Ejemplo: Cuaderno Norma
    private String cantidad;//Longitud: 10              Ejemplo: 15

    //Todos los string de longitud fija usan StringUtils.rightPad y se rellenan con espacios en blanco
    //excepto si son IDs de la clase, esos usan StringUtils.leftPad y se rellenan con ceros
    public Detalle(String id, String idFactura, String nombreProducto, String cantidad) {
        this.id = id;
        this.idFactura = idFactura;
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
    }

    public Detalle() {
    }

    public String getId() {
        return id;
    }

    public String getIdFactura() {
        return idFactura;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setIdFactura(String idFactura) {
        this.idFactura = idFactura;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String asTexto() {
        return id + "\t" + idFactura + "\t" + idProducto + "\t" + nombreProducto + "\t" + cantidad;
    }
}
