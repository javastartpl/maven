docker rm docker-app
docker build -t javastart/docker-application:latest .
docker create -it --name docker-app javastart/docker-application
docker start -ia docker-app
