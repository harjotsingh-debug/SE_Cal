🧮 Calculator CLI - CI/CD DevOps Project

📖 Project Overview

This project is a Java-based Command Line Interface (CLI) Calculator application. It demonstrates a fully automated DevOps CI/CD pipeline using Jenkins, Docker, and Maven.

Every commit to the main branch automatically triggers a pipeline that builds the application, runs unit tests, containerizes the app, and pushes the Docker image to Docker Hub.

🚀 Features

Basic Arithmetic: Addition, Subtraction, Multiplication, Division.

Automated Testing: Unit tests utilizing JUnit framework.

Containerization: Application runs in a lightweight Alpine Linux Docker container.

CI/CD Automation: Zero-touch deployment to Docker Hub via Jenkins.

🛠️ Tech Stack

Language: Java 17 (Eclipse Temurin)

Build Tool: Apache Maven

Testing: JUnit 4

CI/CD Server: Jenkins

Containerization: Docker

Registry: Docker Hub

🔄 CI/CD Pipeline Flow

The automated pipeline consists of the following 8 stages:

graph LR
    A[Push to GitHub] --> B[Jenkins Trigger]
    B --> C[Checkout Code]
    C --> D[Maven Build]
    D --> E[JUnit Tests]
    E --> F[Package JAR]
    F --> G[Docker Build]
    G --> H[Push to DockerHub]


Checkout: Pulls the latest code from GitHub.

Tool Install: Configures Maven environment.

Build: Compiles Java source code (mvn compile).

Test: Runs unit tests (mvn test).

Package: Creates an executable JAR file.

Docker Build: Builds a Docker image using the generated JAR.

Push: Uploads the image to Docker Hub.

💻 How to Run

Option 1: Using Docker (Recommended)

You can pull and run the pre-built image directly from Docker Hub without installing Java.

# Pull the latest image
docker pull harjotsingh12312/imt2023064:latest

# Run the calculator
docker run -it harjotsingh12312/imt2023064:latest


Option 2: Build from Source

If you have Java 17 and Maven installed:

# Clone the repository
git clone [https://github.com/harjotsingh-debug/calculator-cli.git](https://github.com/harjotsingh-debug/calculator-cli.git)

# Navigate to directory
cd calculator-cli

# Build the project
mvn clean package

# Run the JAR
java -jar target/calculator-app-jar-with-dependencies.jar


📂 Project Structure

calculator-cli/
├── src/
│   ├── main/java/       # Source code (Calculator.java)
│   └── test/java/       # Unit tests (CalculatorTest.java)
├── Jenkinsfile          # Jenkins Pipeline definition
├── Dockerfile           # Docker image configuration
├── pom.xml              # Maven dependencies & build config
└── README.md            # Project documentation


🔗 Links

GitHub Repository: [harjotsingh-debug/calculator-cli](https://github.com/harjotsingh-debug/SE_Cal.git)

Docker Hub Repository: harjotsingh12312/imt2023064(https://hub.docker.com/repository/docker/harjotsingh12312/imt2023064/general)

📸 Pipeline Evidence

Build Success

(Add your push.png screenshot here)

Workflow Graph

(Add your graph.png screenshot here)
