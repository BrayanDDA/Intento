pipeline {
    agent any

    //parameters {
    //    string(name: 'TEST_TAG', defaultValue: 'smoke', description: 'Tag de las pruebas a ejecutar')
    //}

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

                //bat 'mvn test'
                //bat 'mvn verify -Dcucumber.options="--plugin json:target/cucumber-report/cucumber.json"'

                script {
                    // Obtener el valor del parámetro ingresado
                    def tag = params.TEST_TAG
                    echo "Running tests with tag: ${tag}"

                    // Ejecuta las pruebas utilizando el tag ingresado
                    //bat "mvn test -Dcucumber.options=\"--tags @${tag}\""

                    // Genera el reporte de Cucumber filtrando por el tag
                    bat 'mvn verify -Dcucumber.options=\"--plugin json:target/cucumber-report/cucumber.json --tags @${tag}\"'
                }
            }
        }

        stage('Cucumber Report') {
            steps {
                echo 'Generating Cucumber report...'
                //bat 'mvn verify -Dcucumber.options="--plugin json:target/cucumber-report/cucumber.json"'
            }
            post {
                always {
                    echo 'Publishing Cucumber report...'
                    cucumber 'target/cucumber-report/cucumber.json'
                }
            }
        }

        stage('Archive Results') {
            steps {
                echo 'Archiving test results and logs...'
                archiveArtifacts artifacts: 'target/surefire-reports/*.xml', allowEmptyArchive: true
                archiveArtifacts artifacts: 'target/cucumber-report/cucumber.json', allowEmptyArchive: true
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
