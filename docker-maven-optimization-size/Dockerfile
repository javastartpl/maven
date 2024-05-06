FROM eclipse-temurin:21-alpine
COPY . /build
WORKDIR /build
RUN ./mvnw clean package &&  \
    cp /build/target/*.jar /opt/app.jar && \
    rm -r /build && \
    rm -r ~/.m2
WORKDIR /opt
ENTRYPOINT ["java", "-jar", "app.jar"]