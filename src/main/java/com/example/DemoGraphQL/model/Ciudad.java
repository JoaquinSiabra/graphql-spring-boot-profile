package com.example.DemoGraphQL.model;

import javax.persistence.*;

@Entity
public class Ciudad {
	@Id
	@Column(name = "ciudad_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "ciudad_nombre", nullable = false)
	private String nombre;

	@OneToOne
	@JoinColumn(name = "fundador_id")
	private Heroe fundador;

	@ManyToOne
	@JoinColumn(name = "rey_id")
	private Heroe rey;
	
	@OneToOne
	@JoinColumn(name = "divinidad_id")
	private Divinidad divinidad;
	
	public Ciudad() {
	}

	public Ciudad(String nombre) {
		super();
		this.nombre = nombre;
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

	public Heroe getFundador() {
		return fundador;
	}

	public void setFundador(Heroe heroe) {
		this.fundador = heroe;
	}
	
	
	public Heroe getRey() {
		return rey;
	}

	public void setRey(Heroe rey) {
		this.rey = rey;
	}
	
	
	public Divinidad getDivinidad() {
		return divinidad;
	}

	public void setDivinidad(Divinidad divinidad) {
		this.divinidad = divinidad;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Ciudad author = (Ciudad) o;

		return id.equals(author.id);
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}

	@Override
	public String toString() {
		return "Ciudad{" + nombre + '}';
	}
}
