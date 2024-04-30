FROM eclipse-temurin:21-alpine
COPY .mvn /tmp/build/.mvn
COPY pom.xml mvnw /tmp/build/
WORKDIR /tmp/build
RUN ./mvnw dependency:go-offline
COPY src /tmp/build/src
RUN ./mvnw clean package
RUN cp /tmp/build/target/*.jar /opt/app.jar && rm -r /tmp/build
WORKDIR /opt
ENTRYPOINT ["java", "-jar", "app.jar"]
