package com.toures.balon.categoria.controlador;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.toures.balon.categoria.modelo.TransaccionModelo;
import com.toures.balon.usuario.servicio.TransaccionService;

@RestController
@RequestMapping("/transaccion")
public class TransaccionControlador {
	private TransaccionService transaccionService;

	@GetMapping("/all")
	public ResponseEntity<List<TransaccionModelo>> buscarTodosPorIdCliente(
			@RequestParam("idUsuario") String idUsuario) {
		return ResponseEntity.ok(transaccionService.buscarTransaccionesPorIdCliente(idUsuario));

	}

}
