FROM alpine:3.19.1
RUN wget -O /etc/apk/keys/adoptium.rsa.pub \
	https://packages.adoptium.net/artifactory/api/security/keypair/public/repositories/apk
RUN echo 'https://packages.adoptium.net/artifactory/apk/alpine/main' >> /etc/apk/repositories
RUN apk add temurin-21-jdk
COPY . /opt/
WORKDIR /opt
#VOLUME /opt/data
ENTRYPOINT ["java", "Application.java"]
