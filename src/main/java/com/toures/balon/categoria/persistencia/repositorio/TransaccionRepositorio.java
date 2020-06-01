package com.toures.balon.categoria.persistencia.repositorio;

import com.toures.balon.categoria.persistencia.entity.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransaccionRepositorio extends JpaRepository<Transaccion, String> {

    Optional<List<Transaccion>> findByIdUsuario(String idUsuario);
	@Query(value = "select * from transaccion t where t.id_usuario=:usuarioId   order by t.fecha_transaccion desc limit 1",nativeQuery = true)
    Optional<Transaccion> buscarUltimaTransaccionPorUsuario(String usuarioId);
}
