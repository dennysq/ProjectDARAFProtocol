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
public class Factura 
{
    //Cuando se armen las cadenas asTexto y cuando se las desmonte se debe hacer en el mismo orden de los
    //atributos de esta clase
    
    private String id;//Longitud fija: 10               Ejemplo: 0000000025  *Se completa con ceros a la ixquierda
    private String fecha;//Longitud fija:8              Ejemplo: yyyyMMdd 20151109
    private String total;//Longitud fija:12             Ejemplo: 1256.30 *Siempre debe tener 2 decimales
    private String idCliente;//Longitud fija: 10        Ejemplo: 0000000114  *Se completa con ceros a la ixquierda

    //Todos los string de longitud fija usan StringUtils.rightPad y se rellenan con espacios en blanco
    //excepto si son IDs de la clase, esos usan StringUtils.leftPad y se rellenan con ceros
    
    public String getId() {
        return id;
    }

    public String getFecha() {
        return fecha;
    }

    public String getTotal() {
        return total;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }
    
}
