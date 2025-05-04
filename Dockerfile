FROM openjdk:21-jdk-slim

WORKDIR /app

COPY *.jar app.jar

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "app.jar"]
