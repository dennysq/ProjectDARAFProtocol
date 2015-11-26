/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daraf.projectdarafprotocol.clienteapp.seguridades;

import com.daraf.projectdarafprotocol.Cuerpo;
import com.daraf.projectdarafprotocol.model.Empresa;
import com.daraf.projectdarafutil.MyStringUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Alejandra Ponce
 */
public class AutenticacionEmpresaRS implements Cuerpo {

    private String resultado; // Si 1: entra, Si 0: no entra
    private Empresa empresa;

    @Override
    public String asTexto() {
        if (this.resultado != null && this.resultado.equals("1")) {
            //solo si es uno retorno con los datos de la empresa encontrada
            return this.resultado + this.empresa.toString();
        } else {
            if (resultado == null) {
                return "2";
            }
            return this.resultado;
        }
    }

    @Override
    public boolean validate(String input) {
        return input != null && input.length() >= 1 && input.length() <= 401;
    }

    @Override
    public void build(String input) {
        if (validate(input)) {
            if (input.length() < 401) {
                input = StringUtils.rightPad(input, 401, " ");
            }
            try {
                String values[] = MyStringUtil.splitByFixedLengths(input, new int[]{1, 400});
                this.resultado = values[0];
                if (resultado.equals("1")) {
                    String empresaValues[] = StringUtils.splitPreserveAllTokens(values[1], Cuerpo.FIELD_SEPARATOR_CHAR);
                    this.empresa = new Empresa();
                    this.empresa.setRuc(empresaValues[0]);
                    this.empresa.setNombre(empresaValues[1]);
                    this.empresa.setTelefono(empresaValues[2]);
                    this.empresa.setDireccion(empresaValues[3]);
                    this.empresa.setUsuario(empresaValues[4]);
                    this.empresa.setPassword(empresaValues[5]);
                }
            } catch (Exception ex) {
                Logger.getLogger(AutenticacionEmpresaRS.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getResultado() {
        return resultado;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

}
