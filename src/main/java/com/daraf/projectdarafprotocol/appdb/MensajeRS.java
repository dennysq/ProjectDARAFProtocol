/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daraf.projectdarafprotocol.appdb;

import com.daraf.projectdarafprotocol.Cabecera;
import com.daraf.projectdarafprotocol.Mensaje;
import com.daraf.projectdarafprotocol.appdb.consultas.ConsultaClienteRS;
import com.daraf.projectdarafprotocol.appdb.consultas.ConsultaFacturaRS;
import com.daraf.projectdarafprotocol.appdb.ingresos.IngresoClienteRS;
import com.daraf.projectdarafprotocol.appdb.ingresos.IngresoFacturaRS;
import com.daraf.projectdarafprotocol.appdb.seguridades.AutenticacionEmpresaRS;

/**
 *
 * @author Alejandra Ponce
 */
public class MensajeRS extends Mensaje {
	public MensajeRS() {
	}

	public MensajeRS(String originador, String idMensaje) {
		this.cabecera = new Cabecera(Mensaje.TIPO_MENSAJE_RESPONSE, originador, idMensaje);
	}

	@Override
	public boolean build(String input) {
		boolean result = true;
		if (validate(input)) {
			this.cabecera = new Cabecera();

			if (this.cabecera.build(input.substring(0, Cabecera.HEADER_LENGTH))) {
				String cuerpo = input.substring(Cabecera.HEADER_LENGTH);

				if (this.cabecera.getTipoMensaje().equals(Mensaje.TIPO_MENSAJE_RESPONSE)) {
					switch (this.cabecera.getIdMensaje()) {
					case ID_MENSAJE_AUTENTICACIONCLIENTE:
						AutenticacionEmpresaRS autenticacionClienteRS = new AutenticacionEmpresaRS();
						autenticacionClienteRS.build(cuerpo);
						this.cuerpo = autenticacionClienteRS;
						break;
					case ID_MENSAJE_CONSULTACLIENTE:
						ConsultaClienteRS consultaClienteRS = new ConsultaClienteRS();
						consultaClienteRS.build(cuerpo);
						this.cuerpo = consultaClienteRS;
						break;
					case ID_MENSAJE_CONSULTAFACTURA:
						ConsultaFacturaRS consultaFacturaRS = new ConsultaFacturaRS();
						consultaFacturaRS.build(cuerpo);
						this.cuerpo = consultaFacturaRS;
						break;
					case ID_MENSAJE_INGRESOCLIENTE:
						IngresoClienteRS ingresoClienteRS = new IngresoClienteRS();
						ingresoClienteRS.build(cuerpo);
						this.cuerpo = ingresoClienteRS;
						break;
					case ID_MENSAJE_INGRESOFACTURA:
						IngresoFacturaRS ingresoFacturaRS = new IngresoFacturaRS();
						ingresoFacturaRS.build(cuerpo);
						this.cuerpo = ingresoFacturaRS;
						break;
					default:
						result = false;
					}
				} else {
					result = false;
				}
			} else {
				result = false;
			}
		} else {
			result = false;
		}
		return result;

	}

}
