/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daraf.projectdarafprotocol.appdb.consultas;

import com.daraf.projectdarafprotocol.Cuerpo;
import com.daraf.projectdarafprotocol.model.Producto;
import com.daraf.projectdarafutil.MyStringUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Alejandra Ponce
 */
public class ConsultaProductoRS implements Cuerpo {

    private String resultado; // Si 1: un solo producto, 2: no encontro; 3: mas 
    private Producto producto;

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String asTexto() {
        if (this.resultado != null && this.resultado.equals("1")) {
            return this.resultado + this.producto.toString();
        } else {
            return this.resultado;
        }
    }

    @Override
    public boolean validate(String input) {
        return input.length() >= 1 && input.length() <= 73;
    }

    @Override
    public void build(String input) {
        
        if (validate(input)) {
            if (input.length() < 401) {
                input = StringUtils.rightPad(input, 73, " ");
            }
            try {
                String values[] = MyStringUtil.splitByFixedLengths(input, new int[]{1, 72});
                this.resultado = values[0];
                if (this.resultado.equals("1")) {
                    String productoValues[] = StringUtils.splitPreserveAllTokens(values[1], Cuerpo.FIELD_SEPARATOR_CHAR);
                    this.producto = new Producto();
                    this.producto.setId(productoValues[0]);
                    this.producto.setNombre(productoValues[1]);
                    this.producto.setPrecio(productoValues[2]);
                    this.producto.setCantidad(productoValues[3]);
                }
            } catch (Exception ex) {
                Logger.getLogger(ConsultaProductoRS.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
