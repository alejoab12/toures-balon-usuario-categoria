package com.toures.balon.categoria.servicio.imp;

import com.toures.balon.categoria.excepcion.ExcepcionPersonalizada;
import com.toures.balon.categoria.modelo.BeneficioModelo;
import com.toures.balon.categoria.persistencia.entity.Beneficio;
import com.toures.balon.categoria.persistencia.repositorio.BeneficioRepositorio;
import com.toures.balon.categoria.servicio.BeneficioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class BeneficioServicioImp implements BeneficioServicio {
    @Autowired
    private BeneficioRepositorio beneficioRepositorio;

    @Override
    public List<BeneficioModelo> buscarBeneficios() {
        return StreamSupport.stream(beneficioRepositorio.findAll().spliterator(), false)
                .collect(Collectors.toList()).stream().map(beneficio -> new BeneficioModelo(beneficio)).collect(Collectors.toList());
    }

    @Override
    public void crearYActualizarBeneficio(BeneficioModelo beneficioModelo) {
        beneficioRepositorio.save(beneficioModelo.toEntity());
    }

    @Override
    public void eliminarBeneficio(Integer id) {
        beneficioRepositorio.delete(new Beneficio(id));
    }

    @Override
    public BeneficioModelo buscarBeneficioPorId(Integer id) {
        Optional<Beneficio> optionalBeneficio = beneficioRepositorio.findById(id);
        if (!optionalBeneficio.isPresent()) {
            throw new ExcepcionPersonalizada(404, "beneficio no encontrado");
        }
        return new BeneficioModelo(beneficioRepositorio.findById(id).get());
    }
}
