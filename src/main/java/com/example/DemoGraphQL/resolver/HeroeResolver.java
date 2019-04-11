package com.example.DemoGraphQL.resolver;

import java.util.Set;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.DemoGraphQL.model.Ciudad;
import com.example.DemoGraphQL.model.Heroe;

public class HeroeResolver implements GraphQLResolver<Heroe> {

	public Set<Ciudad> getPosesiones(Heroe heroe) {
		return heroe.getPosesiones();
	}
}
