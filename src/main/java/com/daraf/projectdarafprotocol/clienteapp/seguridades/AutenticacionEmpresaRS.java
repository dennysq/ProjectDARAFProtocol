/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daraf.projectdarafprotocol.clienteapp.seguridades;

import com.daraf.projectdarafprotocol.Cuerpo;

/**
 *
 * @author Alejandra Ponce
 */
public class AutenticacionEmpresaRS implements Cuerpo  {

    private String resultado; // Si 1: entra, Si 0: no entra
    
    @Override
    public String asTexto() {
        return this.resultado;
    }

    @Override
    public boolean validate(String input) {
        return input.length() == 1;
    }

    @Override
    public void build(String input) {
        if(validate(input)){
            this.resultado=input;
        }
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getResultado() {
        return resultado;
    }
    
    
}
