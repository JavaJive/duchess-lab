# Duchess-lab

## Send a message to Kafka

Make the producer send a message to Kafka by making a rest call to `http://localhost:8081/publish`.
The easiest way to do this is to open your browser and navigate to the address.

## Running Kafka and the producer and consumer services

### Run Kafka, producer and consumer in the same Docker

#### Consumer workspace

From the top folder in the consumer workspace, build the project with Maven so you get a jar to place in the Docker image

`mvn install`

Build the docker image and name it "consumer"

`docker build . -t consumer`

#### Producer workspace

From the top folder in the producer workspace, build the project with Maven

`mvn install`

Build the docker image and name it "producer"

`docker build . -t producer`

Run docker compose 

`docker-compose up`

### Run Kafka in Docker, run producer and consumer separately

#### Producer workspace

Run docker compose and specify the compose file with only Kafka/Zookeeper defined

`docker-compose -f docker-compose-kafka.yml up`

Then start the services separately (in your IDEA, run a built jar etc)

### Generic stuff regarding Docker

Stop Docker and clean up resources afterwards with `docker-compose down`
Run this command from the same folder as you did the docker-compose up.

Check what images you have with `docker images`

Check running containers with `docker ps`

Check all containers, both running and inactive, with `docker ps -a`

Remove all unused containers, images, networks etc with `docker system prune`


Find more details regarding the Docker Compose cli here: https://docs.docker.com/compose/reference/overview/
