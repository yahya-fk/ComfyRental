# First stage: Build the application
FROM maven:3.9.6-eclipse-temurin-17 AS build
#WORKDIR /app
COPY . .
#COPY settings.xml /root/.m2/settings.xml
#RUN mvn dependency:resolve
#COPY src ./src
RUN mvn clean package -DskipTests

# Second stage: Run the application
FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app
COPY --from=build /target/ComfyRental-0.0.1-SNAPSHOT.jar ComfyRental.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "ComfyRental.jar"]

# First stage: Build the application
#FROM maven:3.9.6-eclipse-temurin-17 AS build
#WORKDIR /app
#COPY pom.xml .
#COPY settings.xml /root/.m2/settings.xml
#RUN mvn dependency:resolve
#COPY src ./src
#RUN mvn clean package -DskipTests
#
## Second stage: Run the application
#FROM eclipse-temurin:17-jdk-jammy
#WORKDIR /app
#COPY --from=build /app/target/ComfyRental-0.0.1-SNAPSHOT.jar ComfyRental.jar
#EXPOSE 8080
#ENTRYPOINT ["java", "-jar", "ComfyRental.jar"]
