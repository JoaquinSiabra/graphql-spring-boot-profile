package com.example.DemoGraphQL.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.DemoGraphQL.model.Divinidad;
import com.example.DemoGraphQL.model.Heroe;
import com.example.DemoGraphQL.repository.CiudadRepository;
import com.example.DemoGraphQL.repository.DivinidadRepository;
import com.example.DemoGraphQL.repository.HeroeRepository;

public class Mutation implements GraphQLMutationResolver {

	private CiudadRepository ciudadRepository;
	private DivinidadRepository divinidadRepository;
	private HeroeRepository heroeRepository;

	public Mutation(CiudadRepository ciudadRepository, DivinidadRepository divinidadRepository,
			HeroeRepository heroeRepository) {
		this.ciudadRepository = ciudadRepository;
		this.divinidadRepository = divinidadRepository;
		this.heroeRepository = heroeRepository;
	}

	public Heroe newHeroe(String nombre, String apellido) {
		Heroe heroe = new Heroe();
		heroe.setNombre(nombre);
		heroe.setApellido(apellido);

		heroeRepository.save(heroe);

		return heroe;
	}

	
	public Divinidad newDivinidad(String nombre, String epiteto) {
		Divinidad divinidad = new Divinidad();
		divinidad.setNombre(nombre);
		divinidad.setEpiteto(epiteto);

		divinidadRepository.save(divinidad);

		return divinidad;
	}

	public Divinidad newDivinidad(Divinidad divinidad) {
		divinidadRepository.save(divinidad);
		return divinidad;
	}
	
	public boolean deleteCiudad(Long id) {
		ciudadRepository.deleteById(id);
		return true;
	}

	/*
	 * public Book updateBookPageCount(Integer pageCount, Long id) { Optional<Book>
	 * book = bookRepository.findById(id); if(book == null) { throw new
	 * BookNotFoundException("The book to be updated was found", id); } Book b =
	 * book.get(); b.setPageCount(pageCount);
	 * 
	 * bookRepository.save(b);
	 * 
	 * return b; }
	 */
}
