# Build stage
FROM eclipse-temurin:25-jdk-alpine AS builder
WORKDIR /build
COPY . .
RUN chmod +x mvnw && ./mvnw clean package -DskipTests

# Run stage
FROM eclipse-temurin:25-jre-alpine
WORKDIR /service
COPY --from=builder /build/target/*.jar service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-Xmx350m", "-jar", "service.jar"]
