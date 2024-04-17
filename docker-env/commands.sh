docker build -t javastart/docker-application:latest .
docker run --rm --e LANG=pl --name docker-app javastart/docker-application
docker run --rm --env-file=polish.env --name docker-app javastart/docker-application
docker run --rm -e LANG=es --env-file=polish.env --name docker-app javastart/docker-application
