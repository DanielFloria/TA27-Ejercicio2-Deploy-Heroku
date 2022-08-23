package com.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.dao.IAsignadoADAO;
import com.crud.dto.AsignadoA;

@Service
public class AsignadoAServiceImpl implements IAsignadoAService {

	@Autowired
	IAsignadoADAO iAsignadoADAO;
	
	@Override
	public AsignadoA guardarAsignadoA(AsignadoA asignado_a) {
		return iAsignadoADAO.save(asignado_a);
	}

	@Override
	public List<AsignadoA> listarAsignadoA() {
		return iAsignadoADAO.findAll();
	}

	@Override
	public AsignadoA asignadoAPorId(Long id) {
		return iAsignadoADAO.findById(id).get();
	}

	@Override
	public AsignadoA actualizarAsignadoA(AsignadoA asignado_a) {
		return iAsignadoADAO.save(asignado_a);
	}

	@Override
	public void eliminarAsignadoA(Long id) {
		iAsignadoADAO.deleteById(id);
		
	}

}
