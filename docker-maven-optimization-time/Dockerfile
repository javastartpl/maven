FROM eclipse-temurin:21-alpine
COPY .mvn /build/.mvn
COPY mvnw pom.xml /build/
WORKDIR /build
RUN ./mvnw dependency:go-offline
COPY src /build/src
RUN ./mvnw clean package
RUN cp /build/target/*.jar /opt/app.jar
WORKDIR /opt
ENTRYPOINT ["java", "-jar", "app.jar"]