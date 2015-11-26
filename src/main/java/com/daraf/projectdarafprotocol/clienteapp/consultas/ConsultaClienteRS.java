/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daraf.projectdarafprotocol.clienteapp.consultas;

import com.daraf.projectdarafprotocol.Cuerpo;

/**
 *
 * @author Alejandra Ponce
 */
public class ConsultaClienteRS implements Cuerpo {

    private String resultado;
    private String id;
    private String nombre;
    private String telefono;
    private String direccion;
    @Override
    public String asTexto() {
         return resultado+Cuerpo.FIELD_SEPARATOR_CHAR+id+Cuerpo.FIELD_SEPARATOR_CHAR+nombre
                 +Cuerpo.FIELD_SEPARATOR_CHAR+telefono+Cuerpo.FIELD_SEPARATOR_CHAR+direccion+Cuerpo.FIELD_SEPARATOR_CHAR;
    }

    @Override
    public boolean validate(String input) 
    {
        if(input!=null && input.length()>1 && input.length()<=201)
        {
            return true;
        }else
        {
            return false;
        }
        
    }

    @Override
    public void build(String input) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the resultado
     */
    public String getResultado() {
        return resultado;
    }

    /**
     * @param resultado the resultado to set
     */
    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

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
    
}
