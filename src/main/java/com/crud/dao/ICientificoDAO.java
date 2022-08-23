package com.crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.dto.Cientifico;

public interface ICientificoDAO extends JpaRepository<Cientifico, String> {

}
