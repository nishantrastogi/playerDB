FROM eclipse-temurin:17-jdk-alpine
COPY target/PlayerDB-webapp.jar PlayerDB-webapp.jar
ENTRYPOINT ["java","-jar","PlayerDB-webapp.jar"]