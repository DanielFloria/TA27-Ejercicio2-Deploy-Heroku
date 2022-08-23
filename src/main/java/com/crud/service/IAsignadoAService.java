package com.crud.service;

import java.util.List;

import com.crud.dto.AsignadoA;

public interface IAsignadoAService {
	
	public AsignadoA guardarAsignadoA(AsignadoA asignado_a);
	
	public List<AsignadoA> listarAsignadoA();
	
	public AsignadoA asignadoAPorId(Long id);	
	
	public AsignadoA actualizarAsignadoA(AsignadoA asignado_a);	
	
	public void eliminarAsignadoA(Long id);

}
