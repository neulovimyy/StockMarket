# Use a base image with Java 21

# Stage 1: Build Stage
FROM gradle:7.2.0-jdk11 AS build
WORKDIR /app
COPY . /app
RUN ./gradlew clean build -x test

# Stage 2: Production Stage
FROM eclipse-temurin:21-jdk-alpine

# Set the working directory
ARG JAR_FILE=build/libs/*.jar

WORKDIR /app
# Copy the build artifact from the Gradle build
COPY build/libs/StockMarket-0.0.1.jar app.jar

# Expose the port your application runs on
EXPOSE 8080

# Set the entry point to run the Spring Boot application
ENTRYPOINT ["java", "-jar", "/app.jar"]

