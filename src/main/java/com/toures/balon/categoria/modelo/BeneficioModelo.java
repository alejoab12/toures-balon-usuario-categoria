package com.toures.balon.categoria.modelo;

import com.toures.balon.categoria.persistencia.entity.Beneficio;
import lombok.Data;

@Data
public class BeneficioModelo {
    private Integer id;
    private String nombre;
    private String descripcion;
    private Double descuento;
    public BeneficioModelo(){}
    public BeneficioModelo(Beneficio beneficio) {
        this.id = beneficio.getId();
        this.nombre = beneficio.getNombre();
        this.descripcion = beneficio.getDescripcion();
        this.descuento = beneficio.getDescuento();
    }

    public Beneficio toEntity() {
        Beneficio beneficio = new Beneficio();
        beneficio.setId(this.id);
        beneficio.setNombre(this.nombre);
        beneficio.setDescripcion(this.descripcion);
        beneficio.setDescuento(this.descuento);
        return beneficio;
    }

}
