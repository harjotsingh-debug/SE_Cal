pipeline {
    agent any

    tools {
        // This must match the name you gave Maven in 'Manage Jenkins -> Tools'
        maven 'MavenHome' 
    }

    environment {
        DOCKER_HUB_USER = 'harjotsingh12312'  // Replace with your User
        ROLL_NUMBER = 'IMT2023064' // Replace with your Roll No
        DOCKER_CREDS = credentials('docker-hub-credentials') 
        IMAGE_NAME = "${DOCKER_HUB_USER}/${ROLL_NUMBER}"
    }

    stages {
        stage('Pull Code') {
            steps {
                git branch: 'main', url: 'https://github.com/harjotsingh-debug/calculator-cli.git'
            }
        }

        stage('Build Code') {
            steps {
                // Compiles the Java code using Maven
                bat 'mvn clean compile'
            }
        }

        stage('Test Code') {
            steps {
                // Runs the JUnit tests
                bat 'mvn test'
            }
        }

        stage('Package Jar') {
             steps {
                 // Creates the Executable Jar file required for the Docker image
                 bat 'mvn package -DskipTests'
             }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    echo 'Building Docker Image...'
                    // We need the JAR file to exist before this runs
                    bat "docker build -t %IMAGE_NAME%:latest ."
                }
            }
        }

        stage('Push to Docker Hub') {
            steps {
                script {
                    echo 'Pushing to Docker Hub...'
                    bat "echo %DOCKER_CREDS_PSW% | docker login -u %DOCKER_CREDS_USR% --password-stdin"
                    bat "docker push %IMAGE_NAME%:latest"
                }
            }
        }
    }
}
