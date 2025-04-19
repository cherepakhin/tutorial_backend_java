pipeline {
    agent any
    options {
        durabilityHint 'MAX_SURVIVABILITY'
    }
    stages {
        stage('git clone') {
            steps {
                sh 'pwd'
                sh 'rm -rf tutorial_backend'
                sh 'git clone https://github.com/cherepakhin/tutorial_backend_java.git'
                sh 'ls'
            }
        }
        stage('unit tests') {
            steps {
                sh 'ls'
                sh 'cd tutorial_backend_java;chmod +x mvnw;ls -al;pwd'
                sh 'pwd;echo test;ls -al;cd tutorial_backend_java;./mvnw test -Dtest=!*_IntegrationTest'
                sh 'ls'
            }
        }
        stage('deploy to nexus') {
            steps {
                sh 'echo DEPLOY'
                sh 'ls'
                sh 'echo --------------------NEXUS_CI_USER'
                sh 'echo $NEXUS_CI_USER'
                sh 'echo --------------------NEXUS_CI_PASS'
                sh 'echo $NEXUS_CI_PASS'
                sh 'echo SET--------------------NEXUS_CI_PASS'
                sh 'export NEXUS_CI_PASS=pass'
                sh 'echo $NEXUS_CI_PASS'
                sh 'echo --------------------'
                sh 'set'
                sh 'echo --------------------'
                sh 'cd  tutorial_backend_java;ls;export NEXUS_CI_USER=admin; export NEXUS_CI_PASS=pass; mvn -X -Dmaven.test.skip=true deploy'
                sh 'ls'
            }
        }
    }
}