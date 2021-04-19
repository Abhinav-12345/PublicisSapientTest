pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/Abhinav-12345/PublicisSapientTest.git'

                // Run Maven on a Unix agent.
                sh "mvn clean install"
            }
        }
        stage('Deploy') {
            steps {
                sshagent(['deploy_user']) {
                sh "scp -o StrictHostChecking=no webapp/target/webapp.war Ubuntu@18.217.63.227:/opt/apache-tomcat-8.5.55/webapp"
                }
            }

        }
        }
    }