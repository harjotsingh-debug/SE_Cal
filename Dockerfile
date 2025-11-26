# Use OpenJDK to run the app
FROM openjdk:11-jre-slim

# Set working directory
WORKDIR /app

# Copy the JAR file built by Jenkins/Maven into the image
# Note: The jar name 'calculator-app-jar-with-dependencies.jar' comes from the pom.xml config
COPY target/calculator-app-jar-with-dependencies.jar app.jar

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
