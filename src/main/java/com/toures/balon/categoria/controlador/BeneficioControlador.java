package com.toures.balon.categoria.controlador;

import com.toures.balon.categoria.modelo.BeneficioModelo;
import com.toures.balon.categoria.servicio.BeneficioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/categoria/beneficio")
@RestController
public class BeneficioControlador {
    @Autowired
    private BeneficioServicio beneficioServicio;

    @GetMapping(value = "/all", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<BeneficioModelo>> buscarBeneficios() {

        return ResponseEntity.ok(beneficioServicio.buscarBeneficios());
    }

    @GetMapping
    public ResponseEntity<BeneficioModelo> buscarBeneficioPorId(@RequestParam("idBeneficio") Integer idBeneficio) {
        return ResponseEntity.ok(beneficioServicio.buscarBeneficioPorId(idBeneficio));
    }

    @PostMapping
    public ResponseEntity<Void> crearBeneficio(@Valid @RequestBody BeneficioModelo beneficio,
                                               BindingResult resultadoValidacion) {
        this.beneficioServicio.crearYActualizarBeneficio(beneficio);
        return ResponseEntity.ok().build();
    }


    @DeleteMapping
    public ResponseEntity<Void> eliminarBeneficio(@RequestParam("idBeneficio") Integer idBeneficio) {
        this.beneficioServicio.eliminarBeneficio(idBeneficio);
        return ResponseEntity.ok().build();
    }


}
