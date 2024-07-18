# Stage 1: Build Stage
FROM gradle:jdk21-alpine as builder

COPY ./src /home/gradle/src
COPY ./build.gradle /home/gradle/build.gradle
COPY ./settings.gradle /home/gradle/settings.gradle

WORKDIR /home/gradle

# Build application
RUN gradle clean build -x test

# Stage 2: Production Stage
FROM openjdk:17-jdk-alpine

COPY --from=builder /home/gradle/build/libs/*.jar app.jar

EXPOSE 8080

ARG REDIS_HOST
ARG REDIS_PORT

CMD ["java", "-jar", "app.jar"]