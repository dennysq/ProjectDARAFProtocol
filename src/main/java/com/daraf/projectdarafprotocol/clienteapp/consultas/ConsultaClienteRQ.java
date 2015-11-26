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
public class ConsultaClienteRQ implements Cuerpo {

    private String identificacion;
    
    @Override
    public String asTexto() {
        return identificacion; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean validate(String input) {
        if(input!=null && input.length()<=15)
        {
            return true;
        }else
        {
            return false;
        }
    }

    @Override
    public void build(String input) {
        if(this.validate(input))
        {
            setIdentificacion(input);
        }
        
    }

    /**
     * @return the identificacion
     */
    public String getIdentificacion() {
        return identificacion;
    }

    /**
     * @param identificacion the identificacion to set
     */
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }


    
}
