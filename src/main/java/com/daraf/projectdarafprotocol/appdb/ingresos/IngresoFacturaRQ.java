/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daraf.projectdarafprotocol.appdb.ingresos;

import com.daraf.projectdarafprotocol.Cuerpo;
import com.daraf.projectdarafprotocol.model.Detalle;
import com.daraf.projectdarafutil.MyStringUtil;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Alejandra Ponce
 */
public class IngresoFacturaRQ implements Cuerpo {

    private String idFactura;
    private String identificacionCliente;
    private String fecha;
    private String total;

    private List<Detalle> detalles;
    private String numeroDetalles;

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFecha() {
        return fecha;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = StringUtils.leftPad(total, 10, "0");
    }

    public String getIdentificacionCliente() {
        return identificacionCliente;
    }

    public void setIdFactura(String idFactura) {
        this.idFactura = StringUtils.leftPad(idFactura, 10, "0");
    }

    public String getIdFactura() {
        return idFactura;
    }

    public void setIdentificacionCliente(String identificacionCliente) {
        this.identificacionCliente = StringUtils.rightPad(identificacionCliente, 20);
    }

    public List<Detalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<Detalle> detalles) {
        this.detalles = detalles;

    }

    public String getNumeroDetalles() {
        return numeroDetalles;
    }

    public void setNumeroDetalles(String numeroDetalles) {
        this.numeroDetalles = StringUtils.leftPad(numeroDetalles, 4, "0");
    }

    @Override
    public String asTexto() {
        return this.idFactura + this.identificacionCliente + this.fecha + this.total + this.numeroDetalles + detallesAsTexto();
    }

    @Override
    public boolean validate(String input) {
        return input.length() >= 1 && input.length() <= 2000;
    }

    @Override
    public void build(String input) {
        if (validate(input)) {
            if (input.length() < 2000) {
                input = StringUtils.rightPad(input, 2000);
            }
            try {

                String values[] = MyStringUtil.splitByFixedLengths(input, new int[]{10, 20, 8, 10, 4, 1948});
                this.idFactura = values[0];
                this.identificacionCliente = values[1];
                this.fecha = values[2];
                this.total = values[3];
                this.numeroDetalles = values[4];
                int num = Integer.parseInt(numeroDetalles);
                int stringIndex = 0;
                Detalle det = null;
                String detallesValue[] = StringUtils.splitPreserveAllTokens(values[5], FIELD_SEPARATOR_CHAR);
                if (detalles == null) {
                    detalles = new ArrayList<>();
                } else {
                    detalles.clear();
                }
                for (int i = 0; i < num; i++) {
                    det = new Detalle();
                    det.setIdFactura(detallesValue[stringIndex].trim());
                    stringIndex++;
                    det.setIdProducto(detallesValue[stringIndex].trim());
                    stringIndex++;
                    det.setNombreProducto(detallesValue[stringIndex].trim());
                    stringIndex++;
                    det.setCantidad(detallesValue[stringIndex].trim());
                    stringIndex++;
                    this.detalles.add(det);
                }

            } catch (Exception ex) {
                System.out.println("" + ex);
            }
        }
    }

    private String detallesAsTexto() {
        String res = "";
        if (detalles != null) {
            for (int i = 0; i < detalles.size(); i++) {
                res += detalles.get(i).toString();
            }
        }
        return res;
    }

}
