# Use an official Maven image as the base image
FROM maven:3.9.9-eclipse-temurin-23-noble AS build
WORKDIR /app
# Copy the pom.xml and the project files to the container
COPY pom.xml .
COPY ./java/src ./java/src
# Build the application using Maven
RUN mvn clean package -DskipTests

FROM eclipse-temurin:8-jre-noble
WORKDIR /app
# Copy the built JAR file from the previous stage to the container
COPY --from=build /app/target/hotelapi-1.0-SNAPSHOT.jar .
# Set the command to run the application
CMD ["java", "-jar", "my-application.jar"]

