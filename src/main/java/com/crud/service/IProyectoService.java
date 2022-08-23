package com.crud.service;

import java.util.List;

import com.crud.dto.Proyecto;

public interface IProyectoService {
	public Proyecto guardarProyecto(Proyecto proyecto);
	
	public List<Proyecto> listarProyecto();
	
	public Proyecto proyectoPorId(String id);	
	
	public Proyecto actualizarProyecto(Proyecto proyecto);	
	
	public void eliminarProyecto(String id);
}
