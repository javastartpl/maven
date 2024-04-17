docker rm docker-app
docker build -t javastart/docker-application:latest .
docker rm docker-app
docker create -it --name docker-app javastart/docker-application
docker start -ia docker-app
docker run -it --rm --name docker-app javastart/docker-application
