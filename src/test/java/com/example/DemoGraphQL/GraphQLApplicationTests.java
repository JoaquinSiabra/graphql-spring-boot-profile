package com.example.DemoGraphQL;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.util.Iterator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GraphQLApplicationTests {
	
	static final String URI_GRAPH = "http://localhost:8080/graphql/";

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testTodasCiudades() throws IOException {
		
		RestTemplate restTemplate = new RestTemplate();
		String request = "{\"query\":\"\\n\\n{\\n  heroe(nombre: \\\"Agamenon\\\") {\\n    posesiones{divinidad{nombre}}\\n  } \\n}\",\"variables\":null,\"operationName\":null}";

		ResponseEntity<String> response = restTemplate.postForEntity(URI_GRAPH,request, String.class);
		
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode rootNode = objectMapper.readTree(response.getBody());
		JsonNode posesionesNode = rootNode.path("data");
		Iterator<JsonNode> elements = posesionesNode.elements();		
		JsonNode divinidades = elements.next();
			
		assertThat(divinidades.get("posesiones").toString(), is("[{\"divinidad\":{\"nombre\":\"Hera\"}},{\"divinidad\":{\"nombre\":\"Hera\"}}]"));
	}

}
