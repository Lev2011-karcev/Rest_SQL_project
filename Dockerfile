# Этап 1: сборка приложения (оставляем JDK 24)
FROM maven:3.9-eclipse-temurin-24 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Этап 2: запуск приложения с Java 24 (заменил с 17-jre на 24-jre)
FROM eclipse-temurin:24-jre
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
