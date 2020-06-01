package com.toures.balon.categoria.controlador;

import com.toures.balon.categoria.modelo.CategoriaModelo;
import com.toures.balon.categoria.servicio.CategoriaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/categoria")
@RestController
public class CategoriaControlador {
    @Autowired
    private CategoriaServicio categoriaServicio;
    private @Valid CategoriaModelo categoria;

    @GetMapping(value = "/all", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<CategoriaModelo>> buscarTodos() {

        return ResponseEntity.ok(categoriaServicio.buscarCategorias());
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<CategoriaModelo> buscarPorId(@RequestParam Integer id) {

        return ResponseEntity.ok(categoriaServicio.buscarCategoriaPorId(id));
    }

    @PostMapping
    public ResponseEntity<Void> crearCategoria(@Valid @RequestBody CategoriaModelo categoria, BindingResult resultadoValidacion) {
        categoriaServicio.crearYActualizarCategoria(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @DeleteMapping
    public ResponseEntity<Void> eliminarCategoria(@RequestParam Integer idCategoria) {
        categoriaServicio.eliminarCategoria(idCategoria);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/usuario", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<CategoriaModelo> categoriaPorIdCliente(@RequestParam String usuarioId) {
        return ResponseEntity.ok(this.categoriaServicio.buscarCategoriaPorUsuarioId(usuarioId));
    }

}
