package com.example.DemoGraphQL.model;

import java.util.Set;

import javax.persistence.*;

@Entity
public class Heroe {
	@Id
	@Column(name = "heroe_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "heroe_nombre", nullable = false)
	private String nombre;

	@Column(name = "heroe_apellido", nullable = false)
	private String apellido;
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy="rey")
    private Set<Ciudad> posesiones;

	public Heroe() {
	}

	public Heroe(Long id) {
		this.id = id;
	}

	public Heroe(String firstName, String lastName) {
		this.nombre = firstName;
		this.apellido = lastName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Set<Ciudad> getPosesiones() {
		return posesiones;
	}

	public void setPosesiones(Set<Ciudad> posesiones) {
		this.posesiones = posesiones;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Heroe heroe = (Heroe) o;

		return id.equals(heroe.id);
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}

	@Override
	public String toString() {
		return "Heroe{" + nombre + ' ' + apellido + '}';
	}
}
