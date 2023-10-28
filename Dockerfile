FROM eclipse-temurin:17-jdk-alpine
COPY target/PlayerDB-webapp.jar playerdb-webapp.jar
ENTRYPOINT ["java","-jar","playerdb-webapp.jar"]