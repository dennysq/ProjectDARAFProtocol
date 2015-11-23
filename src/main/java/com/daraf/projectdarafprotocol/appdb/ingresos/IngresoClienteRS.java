/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daraf.projectdarafprotocol.appdb.ingresos;

import com.daraf.projectdarafprotocol.Cuerpo;

/**
 *
 * @author Alejandra Ponce
 */
public class IngresoClienteRS implements Cuerpo {

    private String resultado;
    @Override
    public String asTexto() {
           return this.getResultado();  
    }

    @Override
    public boolean validate(String input) {
     if(input.length()==1){
          return true ; 
        }
        else {
            return false;
        }    }

    @Override
    public void build(String input) {
       if(validate(input)){
            this.setResultado(input);
            
        }    }

    /**
     * @return the reusltado
     */
    public String getResultado() {
        return resultado;
    }

    /**
     * @param reusltado the reusltado to set
     */
    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
    
}
