#!groovy

node('master') {
    stage('Checkout') {
        checkout scm
    }
    
    stage('Run tests') {
        try {
            withMaven(maven: 'Maven 3') {
                dir('bobcat') {
                    sh 'mvn clean test -Dwebdriver.type=remote -Dwebdriver.url=http://host.docker.internal:4444/wd/hub -Dwebdriver.cap.browserName=chrome -Dmaven.test.failure.ignore=true'
                }
            }
        } finally {
            junit testResults: 'bobcat/target/*.xml', allowEmptyResults: true
            archiveArtifacts 'bobcat/target/**'
        }
    }
}
