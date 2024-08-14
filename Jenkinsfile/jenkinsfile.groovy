pipeline {
    agent { label 'primario' }

    stages {
        stage('Build') {
            steps {
                echo 'Building the project...'
                bat 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                echo 'Running tests...'
                bat 'mvn test'
            }
        }

        stage('Cucumber Report') {
            steps {
                echo 'Generating Cucumber report...'
                bat 'mvn verify -Dcucumber.options="--plugin json:target/cucumber-report.json"'
            }
            post {
                always {
                    echo 'Publishing Cucumber report...'
                    cucumber 'target/cucumber-report.json'
                }
            }
        }

        stage('Archive Results') {
            steps {
                echo 'Archiving test results and logs...'
                archiveArtifacts artifacts: 'target/surefire-reports/*.xml', allowEmptyArchive: true
                archiveArtifacts artifacts: 'target/cucumber-report.json', allowEmptyArchive: true
            }
        }

        stage('Clean Up') {
            steps {
                echo 'Cleaning up workspace...'
                cleanWs()
            }
        }
    }

    post {
        always {
            echo 'Pipeline finished'
        }
        success {
            echo 'Pipeline succeeded'
        }
        failure {
            echo 'Pipeline failed'
        }
    }
}
