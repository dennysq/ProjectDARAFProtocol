/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daraf.projectdarafprotocol.clienteapp.seguridades;

import com.daraf.projectdarafprotocol.Cuerpo;
import com.daraf.projectdarafprotocol.model.Empresa;
import com.daraf.projectdarafutil.MyStringUtil;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Alejandra Ponce
 */
public class AutenticacionEmpresaRQ implements Cuerpo {

    private Empresa empresa;

    @Override
    public String asTexto() {
        return this.empresa.getUsuario() + this.empresa.getPassword();
    }

    @Override
    public boolean validate(String input) {
        return input.length() >= 1 && input.length() <= 20;
    }

    @Override
    public void build(String input) {
        if(validate(input)){
            try {
                if (input.length() < 20) {
                    StringUtils.rightPad(input, 20, " ");
                }
                String values[] = MyStringUtil.splitByFixedLengths(input, new int[]{10, 10});
                this.empresa.setUsuario(values[0]);
                this.empresa.setUsuario(values[1]);

            } catch (Exception e) {
                System.out.println("" + e);
            }
        }

    
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    

}
