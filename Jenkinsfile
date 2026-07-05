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
                bat 'docker build -t springboot-practice-app .'
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml'
        }
    }
}