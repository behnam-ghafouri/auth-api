FROM maven:3.8.5-openjdk-17 AS builder
WORKDIR /app
COPY ./pom.xml .
COPY ./src ./src
RUN mvn package -DskipTests

FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
#COPY auth-api/src/main/resources/keystore.p12 /app/keystore.p12
COPY --from=builder /app/target/auth-api-0.0.1-SNAPSHOT.jar /app/app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]