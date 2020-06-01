package com.toures.balon.usuario.servicio;

import com.toures.balon.categoria.modelo.PagoModelo;
import com.toures.balon.categoria.modelo.TransaccionModelo;
import com.toures.balon.usuario.modelo.UsuarioModelo;

import java.util.List;

public interface TransaccionService {
    void crearTransaccionConUsuarioNuevo(UsuarioModelo usuarioModel);

    void sumarPuntos(PagoModelo pago);

    List<TransaccionModelo> buscarTransaccionesPorIdCliente(String idCliente);
}
