/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daraf.projectdarafprotocol.appdb.consultas;

import com.daraf.projectdarafprotocol.Cuerpo;

/**
 *
 * @author Alejandra Ponce
 */
public class ConsultaFacturaRQ implements Cuerpo {

    private String idFactura;

    public String getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(String idFactura) {
        this.idFactura = idFactura;
    }
    
    
    @Override
    public String asTexto() {
        return idFactura;
    }

    @Override
    public boolean validate(String input) {
        if(input!=null && input.length()<=10)
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
            setIdFactura(input);
        }
    }
}
