package com.toures.balon.categoria.modelo;

import java.math.BigDecimal;

import lombok.Data;
@Data
public class CategoriaModelo {
	private Integer id;
	private String nombre;
	private BigDecimal valorRequerido;
}
