package com.toures.balon.categoria.modelo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PagoModelo {
    private String usuarioId;
    private BigDecimal valor;
}
