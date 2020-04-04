package com.toures.balon.categoria.persistencia.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.toures.balon.categoria.persistencia.entity.Transaccion;

@Repository
public interface TransaccionRepositorio extends JpaRepository<Transaccion, String> {
	public List<Transaccion> findByIdUsuario(String idUsuario);
}
