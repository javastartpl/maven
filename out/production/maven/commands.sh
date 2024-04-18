docker build -t javastart/docker-application:latest .
docker volume create docker-app-volume
docker run -it --name docker-app-v2 -v docker-app-volume:/opt/volume-data javastart/docker-application
