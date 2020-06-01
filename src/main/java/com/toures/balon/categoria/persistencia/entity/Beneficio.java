package com.toures.balon.categoria.persistencia.entity;

import com.toures.balon.categoria.modelo.BeneficioModelo;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "beneficio")
@Data
public class Beneficio {
    @Id
    private Integer id;
    private String nombre;
    private String descripcion;
    private double descuento;

    public Beneficio() {
    }

    public Beneficio(Integer id) {
        this.id = id;
    }

    public Beneficio(BeneficioModelo beneficioModelo){
        this.id=beneficioModelo.getId();
        this.nombre=beneficioModelo.getNombre();
        this.setDescripcion(beneficioModelo.getDescripcion());
        this.setDescuento(beneficioModelo.getDescuento());
    }
}
