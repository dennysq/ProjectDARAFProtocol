/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daraf.projectdarafprotocol.appdb.seguridades;

import com.daraf.projectdarafprotocol.Cuerpo;

/**
 *
 * @author Alejandra Ponce
 */
public class AutenticacionEmpresaRQ implements Cuerpo {

    private String identificacion;

    @Override
    public String asTexto() {
        return this.identificacion;
    }

    @Override
    public boolean validate(String input) {
        return input.length() == 20;
    }

    @Override
    public void build(String input) {
        if (validate(input)) {
            this.identificacion = input;

        }
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getIdentificacion() {
        return identificacion;
    }

}
