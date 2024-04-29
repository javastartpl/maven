FROM eclipse-temurin:21-alpine
COPY target/*.jar /opt/app.jar
WORKDIR /opt
ENTRYPOINT ["java", "-jar", "app.jar"]