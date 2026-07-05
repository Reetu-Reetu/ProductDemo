pipeline {
    agent any

    stages {
        stage('Build Maven Project') {
            steps {
                bat 'mvnw.cmd clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                bat '"C:\\Program Files\\Docker\\Docker\\resources\\bin\\docker.exe" build -t springboot-practice-app .'
            }
        }
    }

    post {
        success {
            echo 'Pipeline completed successfully.'
        }

        failure {
            echo 'Pipeline failed.'
        }

        always {
            echo 'Pipeline execution finished.'
        }
    }
}