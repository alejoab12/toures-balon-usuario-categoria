package com.toures.balon.usuario.servicio.imp;

import com.toures.balon.categoria.excepcion.ExcepcionPersonalizada;
import com.toures.balon.categoria.modelo.PagoModelo;
import com.toures.balon.categoria.modelo.TransaccionModelo;
import com.toures.balon.categoria.persistencia.entity.Categoria;
import com.toures.balon.categoria.persistencia.entity.Transaccion;
import com.toures.balon.categoria.persistencia.repositorio.CategoriaRepositorio;
import com.toures.balon.categoria.persistencia.repositorio.TransaccionRepositorio;
import com.toures.balon.usuario.modelo.UsuarioModelo;
import com.toures.balon.usuario.servicio.TransaccionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TransaccionServiceImp implements TransaccionService {
    @Autowired
    private TransaccionRepositorio transaccionRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CategoriaRepositorio categoriaRepositorio;

    @Override
    public void crearTransaccionConUsuarioNuevo(UsuarioModelo usuarioModel) {
        UUID uuid = UUID.randomUUID();
        Transaccion transaccion = new Transaccion();
        transaccion.setAcumuladoTotal(BigDecimal.ZERO);
        transaccion.setValor(BigDecimal.ZERO);
        transaccion.setCategoriaId(new Categoria(1));
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
    public void sumarPuntos(PagoModelo pago) {
        Transaccion transaccion = null;
        Optional<Transaccion> optionalTransaccion = this.transaccionRepo.buscarUltimaTransaccionPorUsuario(pago.getUsuarioId());
        if (!optionalTransaccion.isPresent()) {
            throw new ExcepcionPersonalizada(404, "Usuario No encontrado");
        }
        transaccion = optionalTransaccion.get();
        transaccion.setAcumuladoTotal(new BigDecimal(transaccion.getAcumuladoTotal().doubleValue() + pago.getValor().doubleValue()));
        transaccion.setValor(pago.getValor());
        transaccion.setFechaTransaccion(new Timestamp(System.currentTimeMillis()));
        transaccion.setId(UUID.randomUUID().toString());
        transaccion.setCategoriaId(validarCategoria(transaccion.getAcumuladoTotal()));
        transaccionRepo.saveAndFlush(transaccion);
    }

    private Categoria validarCategoria(BigDecimal totalAcomulado) {
        Categoria categoria = null;
        for (Categoria cate : categoriaRepositorio.findAll()) {
            if (totalAcomulado.doubleValue() >= cate.getPuntosNecesarios().doubleValue()) {
                categoria = cate;
            }
        }
        return categoria;
    }

}
