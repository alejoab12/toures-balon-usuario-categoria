package com.toures.balon.categoria.servicio;

import com.toures.balon.categoria.modelo.CategoriaModelo;

import java.util.List;

public interface CategoriaServicio {
    List<CategoriaModelo> buscarCategorias();

    void crearYActualizarCategoria(CategoriaModelo categoriaModelo);

    void eliminarCategoria(Integer id);

    CategoriaModelo buscarCategoriaPorId(Integer id);

    CategoriaModelo buscarCategoriaPorUsuarioId(String id);
}
