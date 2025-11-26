# Use a lightweight Java image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file built by the "mvn package" stage in Jenkins
# This specific name comes from your Jenkins logs
COPY target/calculator-cli-1.0.0-jar-with-dependencies.jar app.jar

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
