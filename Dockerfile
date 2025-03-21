FROM openjdk:17-jdk-slim

ENV LANG C.UTF-8

WORKDIR /app

COPY build/libs/Test1221.jar /app/Test1221.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "Test1221.jar"]
