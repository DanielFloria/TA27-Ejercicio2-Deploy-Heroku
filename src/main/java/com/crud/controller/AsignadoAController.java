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

import com.crud.dto.AsignadoA;
import com.crud.service.AsignadoAServiceImpl;

@RestController
@RequestMapping("/api")
public class AsignadoAController {

	@Autowired
	AsignadoAServiceImpl asignadoAServiceImpl;

	@PostMapping("/asignadoA")
	public AsignadoA guardarAsignadoA(@RequestBody AsignadoA asignadoA) {
		return asignadoAServiceImpl.guardarAsignadoA(asignadoA);
	}

	@GetMapping("/asignadoA")
	public List<AsignadoA> listarAsignadoA() {
		return asignadoAServiceImpl.listarAsignadoA();
	}

	@GetMapping("/asignadoA/{codigo}")
	public AsignadoA asignadoAPorId(@PathVariable(name="codigo") Long id) {
		AsignadoA asignadoAPorId = new AsignadoA();
		asignadoAPorId = asignadoAServiceImpl.asignadoAPorId(id);

		return asignadoAPorId;
	}	

	@PutMapping("/asignadoA/{codigo}")
	public AsignadoA actualizarAsignadoA(@PathVariable(name="codigo") Long id, @RequestBody AsignadoA asignadoA) {
		AsignadoA asignadoASeleccionado = new AsignadoA();
		AsignadoA asignadoAActualizado = new AsignadoA();

		asignadoASeleccionado = asignadoAServiceImpl.asignadoAPorId(id);

		asignadoASeleccionado.setCientifico(asignadoA.getCientifico());
		asignadoASeleccionado.setProyecto(asignadoA.getProyecto());

		asignadoAActualizado = asignadoAServiceImpl.actualizarAsignadoA(asignadoASeleccionado);

		return asignadoAActualizado;
	}

	@DeleteMapping("/asignadoA/{codigo}")
	public void borrarAsignadoA(@PathVariable(name="codigo") Long id) {
		asignadoAServiceImpl.eliminarAsignadoA(id);
	}

}
