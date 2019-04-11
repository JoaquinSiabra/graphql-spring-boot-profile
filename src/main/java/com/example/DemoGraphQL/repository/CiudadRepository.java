package com.example.DemoGraphQL.repository;

import com.example.DemoGraphQL.model.Ciudad;

import org.springframework.data.repository.CrudRepository;

public interface CiudadRepository extends CrudRepository<Ciudad, Long> {

	Ciudad findByNombre(String nombre);
}
