# # Use a base image with Java 21
# FROM eclipse-temurin:21-jdk-alpine
#
# # Set the working directory
# ARG JAR_FILE=build/libs/*.jar
#
# # Copy the build artifact from the Gradle build
# COPY build/libs/StockMarket-0.0.1.jar app.jar
#
# # Expose the port your application runs on
# EXPOSE 8080
#
# # Set the entry point to run the Spring Boot application
# ENTRYPOINT ["java", "-jar", "/app.jar"]



# prod
# Stage 1: Build Stage
FROM gradle:jdk21-alpine as builder

COPY ./src /home/gradle/src
COPY ./build.gradle /home/gradle/build.gradle
COPY ./settings.gradle /home/gradle/settings.gradle

WORKDIR /home/gradle

# Build application
RUN gradle clean build -x test

# Stage 2: Production Stage
FROM openjdk:21-jdk-alpine

COPY --from=builder /home/gradle/build/libs/*.jar app.jar

EXPOSE 8080

ARG REDIS_HOST
ARG REDIS_PORT

CMD ["java", "-jar", "app.jar"]
