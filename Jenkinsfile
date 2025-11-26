pipeline {
    agent any

    tools {
        // This must match the name you gave Maven in 'Manage Jenkins -> Tools'
        maven 'MavenHome' 
    }

    environment {
        DOCKER_HUB_USER = 'harjotsingh12312'  // Replace with your DockerHub Username
        ROLL_NUMBER = 'imt2023064' // Replace with your Roll No
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
                // CHANGED: used 'sh' instead of 'bat'
                sh 'mvn clean compile'
            }
        }

        stage('Test Code') {
            steps {
                // CHANGED: used 'sh' instead of 'bat'
                sh 'mvn test'
            }
        }

        stage('Package Jar') {
             steps {
                 // CHANGED: used 'sh' instead of 'bat'
                 sh 'mvn package -DskipTests'
             }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    echo 'Building Docker Image...'
                    // CHANGED: used 'sh' instead of 'bat'
                    sh "docker build -t $IMAGE_NAME:latest ."
                }
            }
        }

        stage('Push to Docker Hub') {
            steps {
                script {
                    echo 'Pushing to Docker Hub...'
                    // CHANGED: used 'sh' instead of 'bat'
                    // Note: Linux uses $VAR for variables, not %VAR%
                    sh "echo $DOCKER_CREDS_PSW | docker login -u $DOCKER_CREDS_USR --password-stdin"
                    sh "docker push $IMAGE_NAME:latest"
                }
            }
        }
    }
}
