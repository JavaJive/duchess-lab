FROM openjdk:11-jre-slim

COPY target/producer-application.jar /
COPY src/main/resources/application.yaml /

ENTRYPOINT ["sh", "-c"]
CMD ["java -jar producer-application.jar"]