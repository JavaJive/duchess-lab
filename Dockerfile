FROM openjdk:11-jre-slim

COPY target/producer-application.jar /

ENTRYPOINT ["sh", "-c"]
CMD ["java -jar producer-application.jar"]