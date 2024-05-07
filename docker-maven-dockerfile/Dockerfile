FROM eclipse-temurin:21-alpine
COPY target/validator-*.jar /opt/app.jar
WORKDIR /opt
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
