package com.crud.service;

import java.util.List;

import com.crud.dto.Cientifico;

public interface ICientificoService {
	public Cientifico guardarCientifico(Cientifico cientifico);
	
	public List<Cientifico> listarCientifico();
	
	public Cientifico cientificoPorId(String dni);	
	
	public Cientifico actualizarCientifico(Cientifico cientifico);	
	
	public void eliminarCientifico(String dni);
}
