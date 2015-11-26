/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daraf.projectdarafprotocol.clienteapp.ingresos;

import com.daraf.projectdarafprotocol.Cuerpo;
import com.daraf.projectdarafprotocol.model.DetalleFactura;
import com.daraf.projectdarafutil.MyStringUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Alejandra Ponce
 */
public class IngresoFacturaRQ implements Cuerpo {

    private String identificacion;
    private String nombre;
    private String telefono;
    private String direccion;
    private String numeroDetalles;
    private List<DetalleFactura> detalles;

    public void setNumeroDetalles(String numeroDetalles) {
        this.numeroDetalles = StringUtils.leftPad(numeroDetalles, 4, "0");
    }

    public String getNumeroDetalles() {
        return numeroDetalles;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = StringUtils.rightPad(identificacion, 20);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = StringUtils.rightPad(nombre, 40);
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = StringUtils.rightPad(telefono, 15);
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = StringUtils.rightPad(direccion, 100);
    }

    public List<DetalleFactura> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleFactura> detalles) {
        this.detalles = detalles;
    }

    @Override
    public String asTexto() {
        return this.identificacion + this.nombre + this.telefono + this.direccion + this.numeroDetalles + detallesAsTexto();
    }

    @Override
    public boolean validate(String input) {
        return input.length() >= 1 && input.length() <= 2000;
    }

    @Override
    public void build(String input) {
        if (validate(input)) {
//            if (input.length() == 1 && input.equals("2")) {
//                //no se ha registrado correctamente la factura
//
//            } else 
            if (input.length() < 2000) {
                input = StringUtils.rightPad(input, 2000);
            }
            try {
                String facturaValues[] = MyStringUtil.splitByFixedLengths(input, new int[]{20, 40, 15, 100, 4, 1821});
                this.identificacion = facturaValues[0];
                this.nombre = facturaValues[1];
                this.telefono = facturaValues[2];
                this.direccion = facturaValues[3];
                this.numeroDetalles = facturaValues[4];
                int numFacturas = Integer.parseInt(this.numeroDetalles);
                String detalleValues[] = StringUtils.splitPreserveAllTokens(facturaValues[5], FIELD_SEPARATOR_CHAR);

                if (detalles == null) {
                    detalles = new ArrayList<>();
                } else {
                    detalles.clear();
                }
                int stringIndex = 0;

                DetalleFactura f = null;
                for (int i = 0; i < numFacturas; i++) {
                    f = new DetalleFactura();
                    f.setIdProducto(facturaValues[stringIndex].trim());
                    stringIndex++;
                    f.setNombre(facturaValues[stringIndex].trim());
                    stringIndex++;
                    f.setPrecio(facturaValues[stringIndex].trim());
                    stringIndex++;
                    f.setCantidad(facturaValues[stringIndex].trim());
                    stringIndex++;
                    this.detalles.add(f);
                }
            } catch (Exception ex) {
                Logger.getLogger(IngresoFacturaRQ.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    private String detallesAsTexto() {
        String text = "";
        if (detalles != null) {
            for (int i = 0; i < detalles.size(); i++) {
                text += detalles.get(i).toString();
            }
        }
        return text;
    }
}
