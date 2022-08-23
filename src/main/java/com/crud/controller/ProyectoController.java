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

import com.crud.dto.Proyecto;
import com.crud.service.ProyectoServiceImpl;

@RestController
@RequestMapping("/api")
public class ProyectoController {

	@Autowired
	ProyectoServiceImpl proyectoServiceImpl;

	@PostMapping("/proyectos")
	public Proyecto guardarProyecto(@RequestBody Proyecto proyecto) {
		return proyectoServiceImpl.guardarProyecto(proyecto);
	}

	@GetMapping("/proyectos")
	public List<Proyecto> listarProyectos() {
		return proyectoServiceImpl.listarProyecto();
	}

	@GetMapping("/proyectos/{id}")
	public Proyecto proyectoPorId(@PathVariable(name="id") String id) {
		Proyecto proyectoPorId = new Proyecto();
		proyectoPorId = proyectoServiceImpl.proyectoPorId(id);
		
		return proyectoPorId;
	}	

	@PutMapping("/proyectos/{id}")
	public Proyecto actualizarProyecto(@PathVariable(name="id") String id, @RequestBody Proyecto proyecto) {
		Proyecto proyectoSeleccionado = new Proyecto();
		Proyecto proyectoActualizado = new Proyecto();

		proyectoSeleccionado = proyectoServiceImpl.proyectoPorId(id);

		proyectoSeleccionado.setNombre(proyecto.getNombre());
		proyectoSeleccionado.setHoras(proyecto.getHoras());

		proyectoActualizado = proyectoServiceImpl.actualizarProyecto(proyectoSeleccionado);

		return proyectoActualizado;
	}

	@DeleteMapping("/proyectos/{id}")
	public void borrarProyecto(@PathVariable(name="id") String id) {
		proyectoServiceImpl.eliminarProyecto(id);
	}

}

