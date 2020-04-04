package com.toures.balon.usuario.servicio;

import java.util.List;

import com.toures.balon.categoria.modelo.TransaccionModelo;
import com.toures.balon.usuario.modelo.UsuarioModelo;

public interface TransaccionService {
	public void crearTransaccionConUsuarioNuevo(UsuarioModelo usuarioModel);
	
	public void sumarPuntos();

	public List<TransaccionModelo> buscarTransaccionesPorIdCliente(String idCliente);
}
