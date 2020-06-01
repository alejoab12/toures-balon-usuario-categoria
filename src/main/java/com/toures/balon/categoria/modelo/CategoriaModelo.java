package com.toures.balon.categoria.modelo;

import com.toures.balon.categoria.persistencia.entity.Categoria;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class CategoriaModelo {
    private Integer id;
    private String nombre;
    private Double puntosNecesarios;
    private List<BeneficioModelo> beneficios;

    public CategoriaModelo(Categoria categoria) {
        this.id = categoria.getId();
        this.nombre = categoria.getNombre();
        this.puntosNecesarios = categoria.getPuntosNecesarios().doubleValue();
        this.beneficios = categoria.getBeneficios().stream().map(beneficio -> new BeneficioModelo(beneficio)).collect(Collectors.toList());
    }

    public Categoria toEntity() {
        return new Categoria(this);
    }
}
