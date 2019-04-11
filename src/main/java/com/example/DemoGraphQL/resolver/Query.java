package com.example.DemoGraphQL.resolver;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.DemoGraphQL.model.Ciudad;
import com.example.DemoGraphQL.model.Divinidad;
import com.example.DemoGraphQL.model.Heroe;
import com.example.DemoGraphQL.repository.CiudadRepository;
import com.example.DemoGraphQL.repository.DivinidadRepository;
import com.example.DemoGraphQL.repository.HeroeRepository;

public class Query implements GraphQLQueryResolver {

	private CiudadRepository ciudadRepository;
	private DivinidadRepository divinidadRepository;
	private HeroeRepository heroeRepository;

	public Query(CiudadRepository ciudadRepository, DivinidadRepository divinidadRepository,
			HeroeRepository heroeRepository) {
		this.ciudadRepository = ciudadRepository;
		this.divinidadRepository = divinidadRepository;
		this.heroeRepository = heroeRepository;
	}

	public List<Divinidad> divinidades() {
		return (List<Divinidad>) divinidadRepository.findAll();
	}

	public List<Heroe> heroes() {
		return (List<Heroe>) heroeRepository.findAll();
	}

	public Heroe heroe(String nombre) {
		return heroeRepository.findByNombre(nombre);
	}

	public long countHeroes() {
		return heroeRepository.count();
	}

	public List<Ciudad> ciudades() {
		return (List<Ciudad>) ciudadRepository.findAll();
	}

	public List<Ciudad> ciudadesRey(String rey) {
		return ((List<Ciudad>) ciudadRepository.findAll()).stream().filter(ciudad -> Objects.nonNull(ciudad.getFundador()))
				.filter(ciudad -> ciudad.getFundador().getNombre().equals(rey)).collect(Collectors.toList());
	}

	public Ciudad ciudad(String nombre) {
		return ciudadRepository.findByNombre(nombre);
	}
}
