/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daraf.projectdarafprotocol.clienteapp.consultas;

import com.daraf.projectdarafprotocol.Cuerpo;
import com.daraf.projectdarafprotocol.clienteapp.seguridades.AutenticacionEmpresaRS;
import com.daraf.projectdarafprotocol.model.Cliente;
import com.daraf.projectdarafprotocol.model.Empresa;
import com.daraf.projectdarafutil.MyStringUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Alejandra Ponce
 */
public class ConsultaClienteRS implements Cuerpo {

    private String resultado;
    private Cliente cliente;

    @Override
    public String asTexto() {
        if (this.resultado != null && this.resultado.equals("1")) {
            //solo si es uno retorno con los datos de la empresa encontrada
            return this.resultado + this.cliente.getIdentificacion()+Cuerpo.FIELD_SEPARATOR_CHAR+this.cliente.getNombre()+Cuerpo.FIELD_SEPARATOR_CHAR+this.cliente.getTelefono()
                    +Cuerpo.FIELD_SEPARATOR_CHAR+this.cliente.getDireccion()+Cuerpo.FIELD_SEPARATOR_CHAR;
        } else {
            return this.resultado;
        }
    }

    @Override
    public boolean validate(String input) {
        if (input != null && input.length() > 1 && input.length() <= 201) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public void build(String input) {
        if (validate(input)) {
            if (input.length() < 201) {
                input = StringUtils.rightPad(input, 201, " ");
            }
            try {
                String values[] = MyStringUtil.splitByFixedLengths(input, new int[]{1, 200});
                this.resultado = values[0];
                if (resultado.equals("1")) {
                    String CliValues[] = StringUtils.splitPreserveAllTokens(values[1], Cuerpo.FIELD_SEPARATOR_CHAR);
                    this.cliente = new Cliente();
                    this.cliente.setIdentificacion(CliValues[0]);
                    this.cliente.setNombre(CliValues[1]);
                    this.cliente.setTelefono(CliValues[2]);
                    this.cliente.setDireccion(CliValues[3]);
                }
            } catch (Exception ex) {
                Logger.getLogger(ConsultaClienteRS.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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
