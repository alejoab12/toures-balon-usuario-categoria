package com.toures.balon.categoria.persistencia.entity;

import com.toures.balon.categoria.modelo.CategoriaModelo;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "categoria")
@Data
public class Categoria {
    @Id
    private Integer id;
    private String nombre;
    private BigDecimal puntosNecesarios;
    @OneToMany(targetEntity = Beneficio.class)
    private List<Beneficio> beneficios;

    public Categoria() {
    }

    public Categoria(Integer id) {
        this.id = id;
    }

    public Categoria(CategoriaModelo categoriaModelo) {
        this.id = categoriaModelo.getId();
        this.nombre = categoriaModelo.getNombre();
        this.puntosNecesarios = new BigDecimal(categoriaModelo.getPuntosNecesarios());
        this.setBeneficios(categoriaModelo.getBeneficios().stream().map(beneficio -> new Beneficio(beneficio)).collect(Collectors.toList()));
    }

}
