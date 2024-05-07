FROM eclipse-temurin:21-alpine
COPY . /build
WORKDIR /build
RUN ./mvnw clean package
RUN cp /build/target/validator-*.jar /opt/app.jar
WORKDIR /opt
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
