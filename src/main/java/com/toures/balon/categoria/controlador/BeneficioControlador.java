package com.toures.balon.categoria.controlador;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.MediaType;
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

import com.toures.balon.categoria.modelo.BeneficioModelo;

@RequestMapping("/beneficio")
@RestController
public class BeneficioControlador {

	@GetMapping("/all")

	public ResponseEntity<List<BeneficioModelo>> buscarBeneficios() {

		return null;
	}

	@GetMapping("/categoria")
	public ResponseEntity<List<BeneficioModelo>> buscarBeneficiosPorCategoria(
			@RequestParam("idCategoria") Integer idCategoria) {
		return null;
	}

	@GetMapping
	public ResponseEntity<BeneficioModelo> buscarBeneficioPorId(@RequestParam("idBeneficio") Integer idBeneficio) {
		return null;
	}

	@PostMapping
	public ResponseEntity<Void> crearBeneficio(@Valid @RequestBody BeneficioModelo beneficio,
			BindingResult resultadoValidacion) {
		return null;
	}

	@PostMapping("/categoria/relacion")
	public ResponseEntity<Void> relacionarBeneficioACategoria(@RequestParam("idCategoria") Integer idCategoria,
			@RequestParam("idBeneficio") Integer idBeneficio) {
		return null;
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> actualizarBeneficio(@Valid @RequestBody BeneficioModelo beneficio) {
		return null;
	}

	@DeleteMapping
	public ResponseEntity<Void> eliminarBeneficio(@RequestParam("idBeneficio") Integer idBeneficio) {
		return null;
	}

	@DeleteMapping("/categoria/relacion")
	public ResponseEntity<Void> eliminarRelacionBeneficioACategoria(
			@RequestParam("idBeneficioCategoria") Integer idBeneficioCategoria) {
		return null;
	}

}
