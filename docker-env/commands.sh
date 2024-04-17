docker build -t javastart/docker-application:latest .
docker run --rm --e LANG=pl --name docker-app javastart/docker-application
docker run --rm --env-file=.env --name docker-app javastart/docker-application
docker run --rm -e LANG=es --env-file=.env --name docker-app javastart/docker-application
