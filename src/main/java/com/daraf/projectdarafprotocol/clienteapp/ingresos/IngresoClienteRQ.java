/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daraf.projectdarafprotocol.clienteapp.ingresos;

import com.daraf.projectdarafprotocol.Cuerpo;
import com.daraf.projectdarafprotocol.model.Cliente;
import com.daraf.projectdarafutil.MyStringUtil;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Alejandra Ponce
 */
public class IngresoClienteRQ implements Cuerpo {

    private Cliente cliente;
    @Override
    public String asTexto() 
    {
        return this.cliente.toString();
    }

    @Override
    public boolean validate(String input) 
    {
        if(input.length()>=1 && input.length()<=200)
            return true;
        else
            return false;
    }

    @Override
    public void build(String input) 
    {
        
        if(validate(input))
        {
            try{
               String values[]=StringUtils.splitPreserveAllTokens(input,Cuerpo.FIELD_SEPARATOR_CHAR);
               this.cliente = new Cliente();
                this.cliente.setIdentificacion(values[0]);
                this.cliente.setNombre(values[1]);
                this.cliente.setTelefono(values[2]);
                this.cliente.setDireccion(values[3]);
            }catch(Exception e){
                System.out.println(" "+e);
            }
        }
    }
    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
}
