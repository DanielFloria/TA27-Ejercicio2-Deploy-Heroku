package com.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.dto.Cientifico;
import com.crud.service.CientificoServiceImpl;

@RestController
@RequestMapping("/api")
public class CientificoController {

	@Autowired
	CientificoServiceImpl cientificoServiceImpl;

	@PostMapping("/cientificos")
	public Cientifico guardarCientifico(@RequestBody Cientifico cientifico) {
		return cientificoServiceImpl.guardarCientifico(cientifico);
	}

	@GetMapping("/cientificos")
	public List<Cientifico> listarCientifico() {
		return cientificoServiceImpl.listarCientifico();
	}

	@GetMapping("/cientificos/{dni}")
	public Cientifico cientificoPorId(@PathVariable(name="dni") String dni) {
		Cientifico cientificoPorId = new Cientifico();
		cientificoPorId = cientificoServiceImpl.cientificoPorId(dni);

		return cientificoPorId;
	}	

	@PutMapping("/cientificos/{dni}")
	public Cientifico actualizarCientifico(@PathVariable(name="dni") String dni, @RequestBody Cientifico cientifico) {
		Cientifico cientificoSeleccionado = new Cientifico();
		Cientifico cientificoActualizado = new Cientifico();

		cientificoSeleccionado = cientificoServiceImpl.cientificoPorId(dni);

		cientificoSeleccionado.setNom_apels(cientifico.getNom_apels());

		cientificoActualizado = cientificoServiceImpl.actualizarCientifico(cientificoSeleccionado);

		return cientificoActualizado;
	}

	@DeleteMapping("/cientificos/{dni}")
	public void borrarCientifico(@PathVariable(name="dni") String dni) {
		cientificoServiceImpl.eliminarCientifico(dni);
	}

}

