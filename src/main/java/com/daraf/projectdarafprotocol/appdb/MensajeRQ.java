/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daraf.projectdarafprotocol.appdb;

import com.daraf.projectdarafprotocol.Cabecera;
import com.daraf.projectdarafprotocol.Mensaje;
import com.daraf.projectdarafprotocol.appdb.consultas.ConsultaClienteRQ;
import com.daraf.projectdarafprotocol.appdb.consultas.ConsultaFacturaRQ;
import com.daraf.projectdarafprotocol.appdb.ingresos.IngresoClienteRQ;
import com.daraf.projectdarafprotocol.appdb.ingresos.IngresoFacturaRQ;
import com.daraf.projectdarafprotocol.appdb.seguridades.AutenticacionEmpresaRQ;
import com.daraf.projectdarafprotocol.clienteapp.consultas.ConsultaProductoRQ;

/**
 *
 * @author Alejandra Ponce
 */
public class MensajeRQ extends Mensaje {
	public MensajeRQ() {
	}

	public MensajeRQ(String originador, String idMensaje) {
		this.cabecera = new Cabecera(Mensaje.TIPO_MENSAJE_REQUEST, originador, idMensaje);
	}

	@Override
	public boolean build(String input) {
		boolean result = true;
		if (validate(input)) {
			this.cabecera = new Cabecera();
			// Prueba repositorio GIT
			if (this.cabecera.build(input.substring(0, Cabecera.HEADER_LENGTH))) {
				// se obtiene el resto del mensaje que seria el cuerpo
				String cuerpo = input.substring(Cabecera.HEADER_LENGTH);
				if (this.cabecera.getTipoMensaje().equals(Mensaje.TIPO_MENSAJE_REQUEST)) {
					switch (this.cabecera.getIdMensaje()) {
					case ID_MENSAJE_AUTENTICACIONCLIENTE:
						AutenticacionEmpresaRQ autenticacionClienteRQ = new AutenticacionEmpresaRQ();
                                                autenticacionClienteRQ.build(cuerpo);
						this.cuerpo = autenticacionClienteRQ;
						break;
					case ID_MENSAJE_CONSULTACLIENTE:
						ConsultaClienteRQ consultaClienteRQ = new ConsultaClienteRQ();
						consultaClienteRQ.build(cuerpo);
						this.cuerpo = consultaClienteRQ;
						break;
					case ID_MENSAJE_CONSULTAFACTURA:
						ConsultaFacturaRQ consultaFacturaRQ = new ConsultaFacturaRQ();
						consultaFacturaRQ.build(cuerpo);
						this.cuerpo = consultaFacturaRQ;
						break;
					case ID_MENSAJE_INGRESOCLIENTE:
						IngresoClienteRQ ingresoClienteRQ = new IngresoClienteRQ();
						ingresoClienteRQ.build(cuerpo);
						this.cuerpo = ingresoClienteRQ;
						break;
					case ID_MENSAJE_INGRESOFACTURA:
						IngresoFacturaRQ ingresoFacturaRQ = new IngresoFacturaRQ();
						ingresoFacturaRQ.build(cuerpo);
						this.cuerpo = ingresoFacturaRQ;
						break;
                                        case ID_MENSAJE_CONSULTAPRODUCTO:
						ConsultaProductoRQ consultaProductoRQ = new ConsultaProductoRQ();
						consultaProductoRQ.build(cuerpo);
						this.cuerpo = consultaProductoRQ;
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

