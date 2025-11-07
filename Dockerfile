FROM eclipse-temurin:17
LABEL maintainer="Juan"
WORKDIR /app
COPY target/CadastroDeNinjas-0.0.1-SNAPSHOT.jar /app/cadastro-de-ninjas.jar
ENTRYPOINT ["java", "-jar", "cadastro-de-ninjas.jar"]