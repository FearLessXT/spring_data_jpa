FROM ubuntu:latest
LABEL authors="ppdm"

ENTRYPOINT ["top", "-b"]

FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY target/project-0.0.1-SNAPSHOT.jar /app/project.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "project.jar"]
