# Duchess-lab    

## The system components

Check the "Duchess Meetup at Trustly 2019.pdf" document in this folder for a faboulus diagram 
of our advanced system.

### Producer
The jduchess-2019-producer repo (i.e. this one) contains a skeleton for sending messages
to the Kafka topic "daily-quotes". 

It is already configured to connect to a local Kafka instance at startup.

### Consumer
The jduchess-2019-consumer repo (https://github.com/JavaJive/jduchess-2019-consumer) contains a 
skeleton for consuming messages from the Kafka topic"daily-quotes".

It is already configured to connect to a local Kafka instance at startup.

### Kafka and Zookeeper
You will run Kafka and Zookeeper in Docker via the Docker Compose files in this repo, so no 
installation is required.

## Tasks

- Identify the class that sends messages to Kafka

- Identify the class that receives messages from Kafka

- Send a message to a specific partition

- Send a message with a specific key

- Add error handling when sending messages  

- Log the received message

- Convert the received message to all upper case

- Transform the received message mono to a flux that emits the words in the string one by one

## How to send a message to Kafka

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

## Nice to have links

Reactive manifesto: https://www.reactivemanifesto.org/    

How to read marble diagrams: https://medium.com/@jshvarts/read-marble-diagrams-like-a-pro-3d72934d3ef5

Project Reactor API: https://projectreactor.io/docs/core/release/api/index.html

Project Reactor, which operator to use: https://projectreactor.io/docs/core/release/reference/index.html#which-operator

ReactiveX: http://reactivex.io/

Reactive Streams: http://www.reactive-streams.org/