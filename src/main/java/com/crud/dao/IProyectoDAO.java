package com.crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.dto.Proyecto;

public interface IProyectoDAO extends JpaRepository<Proyecto, String> {

}
