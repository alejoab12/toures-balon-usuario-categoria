package com.toures.balon.categoria.servicio.imp;

import com.toures.balon.categoria.excepcion.ExcepcionPersonalizada;
import com.toures.balon.categoria.modelo.CategoriaModelo;
import com.toures.balon.categoria.persistencia.entity.Categoria;
import com.toures.balon.categoria.persistencia.entity.Transaccion;
import com.toures.balon.categoria.persistencia.repositorio.CategoriaRepositorio;
import com.toures.balon.categoria.persistencia.repositorio.TransaccionRepositorio;
import com.toures.balon.categoria.servicio.CategoriaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CategoriaServicioImp implements CategoriaServicio {
    @Autowired
    private CategoriaRepositorio categoriaRepositorio;
    @Autowired
    private TransaccionRepositorio transaccionRepositorio;

    @Override
    public List<CategoriaModelo> buscarCategorias() {
        return StreamSupport.stream(categoriaRepositorio.findAll().spliterator(), false)
                .collect(Collectors.toList()).stream().map(categoria -> new CategoriaModelo(categoria)).collect(Collectors.toList());
    }

    @Override
    public void crearYActualizarCategoria(CategoriaModelo categoriaModelo) {
        categoriaRepositorio.save(categoriaModelo.toEntity());
    }

    @Override
    public void eliminarCategoria(Integer id) {
        categoriaRepositorio.delete(new Categoria(id));
    }

    @Override
    public CategoriaModelo buscarCategoriaPorId(Integer id) {
        Optional<Categoria> optionalCategoria = categoriaRepositorio.findById(id);
        if (!optionalCategoria.isPresent()) {
            throw new ExcepcionPersonalizada(404, "Categoria no encontrada");
        }
        return new CategoriaModelo(categoriaRepositorio.findById(id).get());
    }

    @Override
    public CategoriaModelo buscarCategoriaPorUsuarioId(String id) {
        Optional<Transaccion> opcionalTransaccion = transaccionRepositorio.buscarUltimaTransaccionPorUsuario(id);
        Categoria categoria = null;
        if (!opcionalTransaccion.isPresent()) {
            throw new ExcepcionPersonalizada(404, "Usuario no tiene categoria");
        }
        categoria = categoriaRepositorio.findById(opcionalTransaccion.get().getCategoriaId().getId()).get();
        return new CategoriaModelo(categoria);
    }
}
