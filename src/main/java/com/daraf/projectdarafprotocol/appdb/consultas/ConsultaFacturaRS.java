/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daraf.projectdarafprotocol.appdb.consultas;

import com.daraf.projectdarafprotocol.Cuerpo;
import static com.daraf.projectdarafprotocol.Cuerpo.FIELD_SEPARATOR_CHAR;
import com.daraf.projectdarafprotocol.clienteapp.ingresos.IngresoFacturaRQ;
import com.daraf.projectdarafprotocol.model.DetalleFacturaAppRQ;
import com.daraf.projectdarafprotocol.model.Factura;
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
public class ConsultaFacturaRS implements Cuerpo {

    private String resultado; // Si 1: un solo producto, 2: no encontro; 3: mas 
    private Factura factura;

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    @Override
    public String asTexto() {
        if (this.resultado != null && this.resultado.equals("1")) {
            return this.resultado + this.factura.toString();
        } else {
            return this.resultado;
        }
    }

    @Override
    public boolean validate(String input) {
        return input.length() >= 1 && input.length() <= 2000;
    }

    @Override
    public void build(String input) {
        if (validate(input)) {
            if (input.length() < 500) {
                input = StringUtils.rightPad(input, 500);
            }
            try {
                String facturaValues[] = MyStringUtil.splitByFixedLengths(input, new int[]{1, 10, 1, 8, 1, 10, 1, 10, 1, 4, 453});
                this.resultado= facturaValues[0];
                this.factura = new Factura();
                this.factura.setId(facturaValues[1]);
                this.factura.setFecha(facturaValues[3]);
                this.factura.setTotal(facturaValues[5]);
                this.factura.setIdentificacionCliente(facturaValues[7]);
                this.factura.setNumeroDetalles(facturaValues[9]);

                String detalleValues[] = StringUtils.splitPreserveAllTokens(facturaValues[10], FIELD_SEPARATOR_CHAR);

                List<DetalleFacturaAppRQ> detallesFactura;
                detallesFactura = new ArrayList<>();

                int stringIndex = 0;

                int valora=Integer.parseInt(this.factura.getNumeroDetalles().trim());
                int valor= valora*2;
                String detalleValores[]= new String[valor];
                
                int j=0;
                for (int i = 0; i < detalleValues.length; i++) {
                    if (i != 0 && i != detalleValues.length-1) {
                        detalleValores[j]=detalleValues[i];
                        j++;
                    }
                }

                DetalleFacturaAppRQ f = null;
                for (int i = 0; i < Integer.parseInt(this.factura.getNumeroDetalles().trim()); i++) {
                    
                    f = new DetalleFacturaAppRQ();
                    f.setIdProducto(detalleValores[stringIndex].trim());
                    stringIndex++;
                    f.setCantidad(detalleValores[stringIndex].trim());
                    stringIndex++;
                    detallesFactura.add(f);
                }
                this.factura.setDetalles(detallesFactura);

            } catch (Exception ex) {
                Logger.getLogger(IngresoFacturaRQ.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
