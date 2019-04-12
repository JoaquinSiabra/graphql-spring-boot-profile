package com.example.DemoGraphQL;

import com.example.DemoGraphQL.model.Ciudad;
import com.example.DemoGraphQL.model.Divinidad;
import com.example.DemoGraphQL.model.Heroe;
import com.example.DemoGraphQL.repository.CiudadRepository;
import com.example.DemoGraphQL.repository.DivinidadRepository;
import com.example.DemoGraphQL.repository.HeroeRepository;
import com.example.DemoGraphQL.resolver.CiudadResolver;
import com.example.DemoGraphQL.resolver.Mutation;
import com.example.DemoGraphQL.resolver.Query;
import org.apache.catalina.connector.Connector;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@ServletComponentScan
public class GraphQLApplication {
	
	
	public static void main(String[] args) {
		SpringApplication.run(GraphQLApplication.class, args);
	}
	
	
	
	//--------Para permitir caracteres como {} y [] en las consultas tenemos que decirselo a Tomcat---------
	@Bean
	public ConfigurableServletWebServerFactory webServerFactory() {
	    TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
	    factory.addConnectorCustomizers(new TomcatConnectorCustomizer() {
	        @Override
	        public void customize(Connector connector) {
	            connector.setProperty("relaxedQueryChars", "|{}[]");
	        }
	    });
	    return factory;
	}
	
	
	//-------------------------------Instancias de los solucionadores--------------------------
	
	@Bean
	public CiudadResolver ciudadResolver(HeroeRepository heroeRepository) {
		return new CiudadResolver(heroeRepository);
	}

	@Bean
	public Query query(CiudadRepository ciudadRepository, DivinidadRepository divinidadRepository,
			HeroeRepository heroeRepository) {
		return new Query(ciudadRepository, divinidadRepository, heroeRepository);
	}

	@Bean
	public Mutation mutation(CiudadRepository ciudadRepository, DivinidadRepository divinidadRepository,
			HeroeRepository heroeRepository) {
		return new Mutation(ciudadRepository, divinidadRepository, heroeRepository);
	}

	
	//-------------------------- Datos de ejemplo ------------------------------
	
	@Bean
	public CommandLineRunner demo2(HeroeRepository heroeRepository, CiudadRepository ciudadRepository,
			DivinidadRepository divinidadRepository) {
		return (args) -> {

			// Heroes
			Heroe perseo = heroeRepository.save(new Heroe("Perseo", ""));
			heroeRepository.save(new Heroe("Aquiles", "Pelida"));
			heroeRepository.save(new Heroe("Diomedes", "Tidida"));
			Heroe agamenon = heroeRepository.save(new Heroe("Agamenon", "Atrida"));
			Heroe ulises = heroeRepository.save(new Heroe("Odiseo", "Laertiada"));
			heroeRepository.save(new Heroe("Nestor", "Nelida"));
			heroeRepository.save(new Heroe("Ajax", "Telamonio"));
			heroeRepository.save(new Heroe("Idomeneo", "Deucalionida"));

			// Divinidades
			Divinidad palas = divinidadRepository.save(new Divinidad("Atenea", "Palas"));
			Divinidad hera = divinidadRepository.save(new Divinidad("Hera", ""));
			Divinidad apolo = divinidadRepository.save(new Divinidad("Apolo", "Musageta"));
			divinidadRepository.save(new Divinidad("Poseidon", ""));
			
			// Ciudades
			Ciudad argos = new Ciudad("Argos");
			argos.setRey(agamenon);
			argos.setFundador(perseo);
			argos.setDivinidad(hera);
			ciudadRepository.save(argos);
			
			Ciudad micenas = new Ciudad("Micenas");
			micenas.setRey(agamenon);
			micenas.setFundador(perseo);			
			micenas.setDivinidad(hera);
			ciudadRepository.save(micenas);

			ciudadRepository.save(new Ciudad("Esparta"));

			Ciudad itaca = new Ciudad("Itaca");
			itaca.setRey(ulises);
			itaca.setDivinidad(palas);
			ciudadRepository.save(itaca);

			Ciudad tirinto = new Ciudad("Tirinto");
			tirinto.setRey(perseo);
			tirinto.setDivinidad(apolo);
			ciudadRepository.save(tirinto);

			
			ciudadRepository.save(new Ciudad("Salamina"));
			ciudadRepository.save(new Ciudad("Creta"));
			ciudadRepository.save(new Ciudad("Pilos"));
			ciudadRepository.save(new Ciudad("Tebas"));

		};
	}
}
