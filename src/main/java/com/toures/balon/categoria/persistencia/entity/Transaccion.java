package com.toures.balon.categoria.persistencia.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

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
	@JoinColumn(name = "categoria_id")
	@ManyToOne(targetEntity = Categoria.class)
	private Categoria categoriaId;
	private BigDecimal valor;
}