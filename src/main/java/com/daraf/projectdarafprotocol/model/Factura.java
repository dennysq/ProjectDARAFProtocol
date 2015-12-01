/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daraf.projectdarafprotocol.model;

import com.daraf.projectdarafprotocol.Cuerpo;
import java.util.List;

/**
 *
 * @author ShipO
 */
public class Factura {
    //Cuando se armen las cadenas asTexto y cuando se las desmonte se debe hacer en el mismo orden de los
    //atributos de esta clase

    private String id;//Longitud fija: 10               Ejemplo: 0000000025  *Se completa con ceros a la ixquierda
    private String identificacionCliente;//Longitud fija: 20        Ejemplo: 0000000114  *Se completa con ceros a la ixquierda
    private String fecha;//Longitud fija:8              Ejemplo: ddMMyyyy 11092013
    private String total;//Longitud fija:10             Ejemplo: 1256.30 *Siempre debe tener 2 decimales

    private String numeroDetalles;
    private List<DetalleFacturaAppRQ> detalles;
    
    
    //Todos los string de longitud fija usan StringUtils.rightPad y se rellenan con espacios en blanco
    //excepto si son IDs de la clase, esos usan StringUtils.leftPad y se rellenan con ceros
    public Factura(String id, String idCliente, String fecha,  String total, String numero) {
        this.id = id;
        this.fecha = fecha;
        this.total = total;
        this.identificacionCliente = idCliente;
        this.numeroDetalles = numero;
    }

    public Factura() {
    }

    public String getId() {
        return id;
    }

    public String getFecha() {
        return fecha;
    }

    public String getTotal() {
        return total;
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

    public List<DetalleFacturaAppRQ> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleFacturaAppRQ> detalles) {
        this.detalles = detalles;
    }

    public String getIdentificacionCliente() {
        return identificacionCliente;
    }

    public void setIdentificacionCliente(String identificacionCliente) {
        this.identificacionCliente = identificacionCliente;
    }

    public String getNumeroDetalles() {
        return numeroDetalles;
    }

    public void setNumeroDetalles(String numeroDetalles) {
        this.numeroDetalles = numeroDetalles;
    }

    
    @Override
    public String toString() {
        //No estoy segura de como debe ir el toString de detalles
        return  id + Cuerpo.FIELD_SEPARATOR_CHAR + 
                fecha + Cuerpo.FIELD_SEPARATOR_CHAR + 
                total + Cuerpo.FIELD_SEPARATOR_CHAR + 
                identificacionCliente + Cuerpo.FIELD_SEPARATOR_CHAR+
                numeroDetalles+Cuerpo.FIELD_SEPARATOR_CHAR + 
                detalleAsTexto();
    }
    
    public String detalleAsTexto(){
        String aux;
        aux="";
        for(int i=0;i<this.detalles.size();i++)
        {
            aux=aux+detalles.get(i).toString();
            
        }
        return aux;
    }
  
    public String astexto() {
        return id + "\t" + fecha + "\t" + total+ "\t" + identificacionCliente + "\t"+numeroDetalles;
    }
}
