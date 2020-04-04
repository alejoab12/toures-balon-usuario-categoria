package com.toures.balon.categoria.modelo;

import java.math.BigDecimal;
import java.sql.Timestamp;

import lombok.Data;
@Data
public class TransaccionModelo {
	private Integer id;
	private Integer idUsuario;
	private BigDecimal valor;
	private BigDecimal acumuladoTotal;
	private Timestamp fechaTransaccion;
}
