package com.crud.dto;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="cientificos")
public class Cientifico {

	@Id
	private String dni;
	@Column(name = "nom_apels")
	private String nom_apels;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cientifico")
    private List<AsignadoA> asignado_a;
	
	public Cientifico() {
	
	}

	public Cientifico(String dni, String nom_apels, List<AsignadoA> asignado_a) {
		this.dni = dni;
		this.nom_apels = nom_apels;
		this.asignado_a = asignado_a;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNom_apels() {
		return nom_apels;
	}

	public void setNom_apels(String nom_apels) {
		this.nom_apels = nom_apels;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "AsignadoA")
	public List<AsignadoA> getAsignado_a() {
		return asignado_a;
	}

	public void setAsignado_a(List<AsignadoA> asignado_a) {
		this.asignado_a = asignado_a;
	}

	@Override
	public String toString() {
		return "Cientifico [dni=" + dni + ", nom_apels=" + nom_apels + ", asignado_a=" + asignado_a + "]";
	}
}


