package com.toures.balon.categoria.servicio;

import com.toures.balon.categoria.modelo.BeneficioModelo;
import com.toures.balon.categoria.modelo.CategoriaModelo;

import java.util.List;

public interface BeneficioServicio {
    List<BeneficioModelo> buscarBeneficios();

    void crearYActualizarBeneficio(BeneficioModelo beneficioMOdelo);

    void eliminarBeneficio(Integer id);

    BeneficioModelo buscarBeneficioPorId(Integer id);
}
