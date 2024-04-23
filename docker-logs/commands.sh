docker build -t javastart/docker-server-app:latest .
docker run --rm -it \
--name server-app \
-v ./data:/opt/data \
-p 8080:8080 \
javastart/docker-server-app

docker run --rm -d \
--name server-app \
-v ./data:/opt/data \
-p 8080:8080 \
javastart/docker-server-app
