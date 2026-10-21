# Étape 1 : build de l'application
FROM eclipse-temurin:25-jdk-jammy AS build

WORKDIR /app

COPY . .

RUN chmod +x mvnw && ./mvnw clean package -DskipTests


# Étape 2 : exécution
FROM eclipse-temurin:25-jre-jammy

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]