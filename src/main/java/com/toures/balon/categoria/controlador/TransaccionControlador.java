package com.toures.balon.categoria.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.toures.balon.categoria.modelo.TransaccionModelo;
import com.toures.balon.usuario.servicio.TransaccionService;

@RestController
@RequestMapping("/categoria/transaccion")
public class TransaccionControlador {
	@Autowired
	private TransaccionService transaccionService;

	@GetMapping(value="/usuario",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<TransaccionModelo>> buscarTodosPorIdCliente(
			@RequestParam String idUsuario) {
		System.out.println(idUsuario);
		return ResponseEntity.ok(transaccionService.buscarTransaccionesPorIdCliente(idUsuario));

	}

}
