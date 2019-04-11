package com.example.DemoGraphQL.repository;

import com.example.DemoGraphQL.model.Heroe;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface HeroeRepository extends CrudRepository<Heroe, Long> {

	Heroe findByNombre(String nombre);

}
