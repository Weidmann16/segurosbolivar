#
# Build stage
#
ARG MSVC_NAME=rickandmorty-service
FROM maven:3.8.3-openjdk-17 AS build
ARG MSVC_NAME
WORKDIR /home/$MSVC_NAME
COPY pom.xml .
RUN mvn dependency:go-offline -B
COPY src ./src
RUN mvn clean package

#
# Package stage
#
FROM openjdk:17-jdk-slim
ARG MSVC_NAME
WORKDIR /home/$MSVC_NAME
COPY --from=build /home/$MSVC_NAME/target/$MSVC_NAME-0.0.1-SNAPSHOT.jar app.jar
ARG APP_PORT=8080
ENV PORT $APP_PORT
EXPOSE $PORT
CMD ["java", "-jar", "app.jar"]