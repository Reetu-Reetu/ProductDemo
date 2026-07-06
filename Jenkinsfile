pipeline {
    agent any

    stages {
        stage('Build and Run Tests') {
            steps {
                bat 'mvnw.cmd clean package'
            }
        }

        stage('Build Docker Image') {
            steps {
                bat 'docker build -t reetur/springboot-practice-app:latest .'
            }
        }

        stage('Push Docker Image') {
            steps {
                bat 'docker push reetur/springboot-practice-app:latest'
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml'
        }

        success {
            echo 'Build, tests, Docker image build and push completed successfully.'
        }

        failure {
            echo 'Pipeline failed.'
        }
    }
}