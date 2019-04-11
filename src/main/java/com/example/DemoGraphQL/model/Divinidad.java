package com.example.DemoGraphQL.model;

import java.util.Set;

import javax.persistence.*;

@Entity
public class Divinidad {
	@Id
	@Column(name = "dios_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "dios_nombre", nullable = false)
	private String nombre;

	@Column(name = "dios_epiteto", nullable = false)
	private String epiteto;

	@OneToMany(mappedBy="divinidad")
    private Set<Ciudad> posesiones;
	
	
	public Divinidad() {
	}

	public Divinidad(Long id) {
		this.id = id;
	}

	public Divinidad(String nombre, String epiteto) {
		this.nombre = nombre;
		this.epiteto = epiteto;
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

	public String getEpiteto() {
		return epiteto;
	}

	public void setEpiteto(String epiteto) {
		this.epiteto = epiteto;
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

		Divinidad dios = (Divinidad) o;

		return id.equals(dios.id);
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}

	@Override
	public String toString() {
		return "Divinidad{" + nombre + '}';
	}
}
