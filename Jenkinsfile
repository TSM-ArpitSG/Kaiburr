pipeline {
  agent any

  stages {
    stage('Checkout') {
      steps {
        checkout scm
      }
    }
    stage('Build') {
      steps {
        sh 'mvn clean package'
      }
    }
    stage('Test') {
      steps {
        sh 'mvn test'
      }
    }
    stage('Docker build') {
      steps {
        sh 'docker build -t myapp .'
      }
    }
    stage('Publish') {
      steps {
        withCredentials([usernamePassword(credentialsId: 'docker-registry', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
          sh 'docker login -u $DOCKER_USER -p $DOCKER_PASS'
          sh 'docker tag myapp:latest arpitsh/myapp:latest'
          sh 'docker push arpitsh/myapp:latest'
        }
      }
    }
    stage('Deploy') {
      steps {
        sh 'docker-compose up -d'
      }
    }
  }
}
