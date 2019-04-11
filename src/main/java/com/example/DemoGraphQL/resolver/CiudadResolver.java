package com.example.DemoGraphQL.resolver;

import java.util.Optional;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.DemoGraphQL.model.Ciudad;
import com.example.DemoGraphQL.model.Divinidad;
import com.example.DemoGraphQL.model.Heroe;
import com.example.DemoGraphQL.repository.HeroeRepository;

public class CiudadResolver implements GraphQLResolver<Ciudad> {

	private HeroeRepository heroeRepository;

	public CiudadResolver(HeroeRepository heroeRepository) {
		this.heroeRepository = heroeRepository;
	}

	public Optional<Heroe> getFundador(Ciudad ciudad) {
		Heroe fundador = ciudad.getFundador();
		if (fundador!=null)
			return heroeRepository.findById(ciudad.getFundador().getId());
		return Optional.empty();
	}
	
	public Optional<Divinidad> getDivinidad(Ciudad ciudad) {
		return Optional.ofNullable(ciudad.getDivinidad());
	}
}
