docker build -t javastart/docker-application:latest .
docker run -it --name docker-app javastart/docker-application
docker cp docker-app:/opt/inside.txt inside.txt
