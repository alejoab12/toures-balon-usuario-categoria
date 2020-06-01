package com.toures.balon.kafka.recurso;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toures.balon.categoria.modelo.PagoModelo;
import com.toures.balon.usuario.modelo.UsuarioModelo;
import com.toures.balon.usuario.servicio.TransaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

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

   @KafkaListener(topics = "toures-balon-pago", groupId = "toures-balon-pago")
    public void listenPagos(String message) throws Exception {
       transaccionService.sumarPuntos(objectMapper.readValue(message, PagoModelo.class));
    }
}
