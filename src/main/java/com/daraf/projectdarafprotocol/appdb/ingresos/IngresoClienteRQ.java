/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daraf.projectdarafprotocol.appdb.ingresos;

import com.daraf.projectdarafprotocol.Cuerpo;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Alejandra Ponce
 */
public class IngresoClienteRQ implements Cuerpo {

    private String id;
    private String nombre;
    private String direccion;
    private String telefono;
    
    
    @Override
    public String asTexto() {
                return this.id+Cuerpo.FIELD_SEPARATOR_CHAR+this.nombre+Cuerpo.FIELD_SEPARATOR_CHAR+this.direccion+Cuerpo.FIELD_SEPARATOR_CHAR+
                this.telefono+Cuerpo.FIELD_SEPARATOR_CHAR;
    }

    @Override
    public boolean validate(String input) {
       if(input.length()>=1 && input.length()<=200)
            return true;
        else
            return false;
    }

    @Override
    public void build(String input) {
if(validate(input))
        {
            try{
               String values[]=StringUtils.splitPreserveAllTokens(input,Cuerpo.FIELD_SEPARATOR_CHAR);
                setId(values[0]);
                setNombre(values[1]);
                setDireccion(values[2]);
                setTelefono(values[3]);
                
            }catch(Exception e){
                System.out.println(" "+e);
            }
        }    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
}
