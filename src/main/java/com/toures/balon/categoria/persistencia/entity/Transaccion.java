package com.toures.balon.categoria.persistencia.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "transaccion")
public class Transaccion {
	@Id
	private String id;
	@Column(name = "id_usuario")
	private String idUsuario;
	@Column(name = "acumulado_total")
	private BigDecimal acumuladoTotal;
	@Column(name = "fecha_transaccion")
	private Timestamp fechaTransaccion;
	@Column(name = "categoria_id")
	private Integer categoriaId;
	private BigDecimal valor;
}