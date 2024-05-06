FROM eclipse-temurin:21-alpine
COPY . /build
WORKDIR /build
RUN ./mvnw clean package
RUN cp /build/target/*.jar /opt/app.jar
WORKDIR /opt
ENTRYPOINT ["java", "-jar", "app.jar"]