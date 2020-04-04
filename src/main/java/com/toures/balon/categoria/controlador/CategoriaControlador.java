package com.toures.balon.categoria.controlador;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.toures.balon.categoria.modelo.CategoriaModelo;

@RequestMapping("/categoria")
@RestController
public class CategoriaControlador {

	@GetMapping("/all")
	public ResponseEntity<List<CategoriaModelo>> buscarTodos() {
		return null;
	}

	@GetMapping("/cliente")
	public ResponseEntity<CategoriaModelo> buscarCategoriaCliente(@RequestParam("id") Integer idCliente) {
		return null;
	}

	@PostMapping
	public ResponseEntity<Void> crearCategoria(@Valid @RequestBody CategoriaModelo categoria,
			BindingResult resultadoValidacion) {
		return null;

	}

	@PutMapping
	public ResponseEntity<Void> actualizarCategoria(@Valid @RequestBody CategoriaModelo categoria,
			BindingResult resultadoValidacion) {
		return null;

	}

	@DeleteMapping
	public ResponseEntity<Void> eliminarCategoria(@RequestParam("idCategoria") Integer idCategoria) {
		return null;

	}

}
