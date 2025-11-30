FROM maven:3.9-eclipse-temurin-17 AS builder
WORKDIR /app
COPY . .
RUN mvn -q -DskipTests=true install

FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=builder /app/target/*.jar lib.jar
ENTRYPOINT ["tail", "-f", "/dev/null"]
