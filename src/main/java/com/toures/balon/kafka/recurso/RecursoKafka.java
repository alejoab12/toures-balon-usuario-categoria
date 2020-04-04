package com.toures.balon.kafka.recurso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toures.balon.usuario.modelo.UsuarioModelo;
import com.toures.balon.usuario.servicio.TransaccionService;

@Component
public class RecursoKafka {
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private TransaccionService transaccionService;

	@KafkaListener(topics = "toures-balon-usuario", groupId = "toures-balon-usuario")
	public void listen(String message) throws Exception {
		transaccionService.crearTransaccionConUsuarioNuevo(objectMapper.readValue(message, UsuarioModelo.class));
	}
}
