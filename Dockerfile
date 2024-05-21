FROM maven:3.9.6-eclipse-temurin-21 AS build


COPY . .
RUN mvn clean package -Dskiptests

FROM openjdk:21-slim
COPY --from=build /target/ComfyRental-0.0.1-SNAPSHOT.jar ComfyRental.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "ComfyRental.jar"]
