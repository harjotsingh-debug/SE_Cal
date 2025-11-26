# Use Eclipse Temurin (Standard OpenJDK replacement)
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# The log confirms your file is named 'calculator-app-jar-with-dependencies.jar'
COPY target/calculator-app-jar-with-dependencies.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
