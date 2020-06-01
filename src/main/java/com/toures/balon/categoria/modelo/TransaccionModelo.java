package com.toures.balon.categoria.modelo;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.toures.balon.categoria.persistencia.entity.Transaccion;
import lombok.Data;
@Data
public class TransaccionModelo {
	private String id;
	private String idUsuario;
	private BigDecimal valor;
	private BigDecimal acumuladoTotal;
	private Timestamp fechaTransaccion;
	public TransaccionModelo(){}
	public TransaccionModelo(Transaccion transaccion){
		this.id=transaccion.getId();
		this.idUsuario=transaccion.getIdUsuario();
		this.valor=transaccion.getValor();
		this.acumuladoTotal=transaccion.getAcumuladoTotal();
		this.fechaTransaccion=transaccion.getFechaTransaccion();
	}
}
