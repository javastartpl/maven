FROM eclipse-temurin:21-alpine
COPY .mvn /build/.mvn
COPY mvnw pom.xml /build/
WORKDIR /build
RUN ./mvnw dependency:go-offline
COPY src /build/src
RUN ./mvnw clean package
RUN cp /build/target/validator-*.jar /opt/app.jar
WORKDIR /opt
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
