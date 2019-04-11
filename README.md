# Ejemplo de servidor GraphQL

Clonar el repositorio y ejecutar `mvnw spring-boot:run`. O en un IDE, ejecutar la clase `com.example.DemoGraphQL.DemoGraphQlApplication`.

En [http://localhost:8080/h2-console/login.jsp](http://localhost:8080/h2-console/login.jsp) hay disponible una consola de la base de datos H2:
- JDBC URL: jdbc:h2:mem:testdb
- User Name: sa
- Password: <blank>

Para probar consultas en GraphIQL: [http://localhost:8080/graphiql](http://localhost:8080/graphiql) 

Consultas de prueba

Todas las ciudades:
{
  ciudades {
    id nombre heroe {nombre apellido}
  } 
}

Ciudad de Micenas:
{
  ciudad(nombre: "Micenas") {
    id nombre 
  } 
}


Ciudades que tienen por rey a Agamenón:
{
  ciudadesRey(nombre: "Agamenon") {
    id nombre 
  } 
}

Borrar la ciudad con id=8:
mutation {
  deleteCiudad(id: 8) 
}

Todos los heroes:
{
  heroes {
    id nombre
  } 
}

El heroe Agamenon:
{
  heroe(nombre: "Agamenon") {
    id nombre
  } 
}

Contar los heroes:
{
  countHeroes
}

Nueva divinidad "Hermes Argifonte":
mutation {
  newDivinidad(nombre:"Hermes", epiteto:"Argifonte"){
    nombre
    epiteto
  }
}

