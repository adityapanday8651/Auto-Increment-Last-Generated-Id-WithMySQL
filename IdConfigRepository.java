package com.comp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comp.model.IdConfig;

public interface IdConfigRepository extends JpaRepository<IdConfig, Integer>{

	IdConfig findByName(String name);

}
