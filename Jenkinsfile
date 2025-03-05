pipeline {
    agent any

    tools {
        maven 'Maven' // Ensure Maven is installed in Jenkins
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/anjalichaudhri/restassuredautomation'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test -Dallure.results.directory=allure-results'
            }
        }
        stage('Generate Allure Report') {
            steps {
                sh 'mvn allure:report'
            }
        }
        stage('Publish Allure Report') {
            steps {
                allure includeProperties: false, jdk: '', results: [[path: 'allure-results']]
            }
        }
    }
    post {
        always {
            archiveArtifacts artifacts: 'allure-report/**', fingerprint: true
        }
    }
}