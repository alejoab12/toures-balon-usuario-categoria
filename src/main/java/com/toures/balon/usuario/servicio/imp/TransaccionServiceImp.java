package com.toures.balon.usuario.servicio.imp;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toures.balon.categoria.modelo.TransaccionModelo;
import com.toures.balon.categoria.persistencia.entity.Transaccion;
import com.toures.balon.categoria.persistencia.repositorio.TransaccionRepositorio;
import com.toures.balon.usuario.modelo.UsuarioModelo;
import com.toures.balon.usuario.servicio.TransaccionService;

@Service
public class TransaccionServiceImp implements TransaccionService {
	@Autowired
	private TransaccionRepositorio transaccionRepo;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public void crearTransaccionConUsuarioNuevo(UsuarioModelo usuarioModel) {
		UUID uuid = UUID.randomUUID();
		Transaccion transaccion = new Transaccion();
		transaccion.setAcumuladoTotal(BigDecimal.ZERO);
		transaccion.setValor(BigDecimal.ZERO);
		transaccion.setCategoriaId(1);
		transaccion.setFechaTransaccion(new Timestamp(System.currentTimeMillis()));
		transaccion.setId(uuid.toString());
		transaccion.setIdUsuario(usuarioModel.getId());
		transaccionRepo.saveAndFlush(transaccion);

	}

	@Override
	public List<TransaccionModelo> buscarTransaccionesPorIdCliente(String idCliente) {
		return transaccionRepo.findByIdUsuario(idCliente).stream().map(t -> modelMapper.map(t, TransaccionModelo.class))
				.collect(Collectors.toList());
	}

	@Override
	public void sumarPuntos() {
		// TODO Auto-generated method stub
		
	}

}
