/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daraf.projectdarafprotocol.appdb.consultas;

import com.daraf.projectdarafprotocol.clienteapp.consultas.*;
import com.daraf.projectdarafprotocol.Cuerpo;

/**
 *
 * @author Alejandra Ponce
 */
public class ConsultaProductoRQ implements Cuerpo  {
    
    private String idProducto;

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }
    

    @Override
    public String asTexto() {
        return idProducto;
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
            setIdProducto(input);
        }
    }
    
    
    
}
