FROM eclipse-temurin:21-alpine
COPY . /tmp/build
WORKDIR /tmp/build
RUN ./mvnw clean package
RUN cp /tmp/build/target/*.jar /opt/app.jar && rm -r /tmp/build
WORKDIR /opt
ENTRYPOINT ["java", "-jar", "app.jar"]