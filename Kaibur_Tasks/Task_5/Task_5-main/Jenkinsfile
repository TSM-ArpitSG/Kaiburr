// Define the agent to use for the pipeline, which can run on any available agent
pipeline {
    agent any

    // Define the tool to use for the pipeline, which is Maven in this case
    tools{
        maven 'maven'
    }

    // Define the stages of the pipeline
    stages{
        // Define the first stage, which is to build the Maven project
        stage('Build Maven'){
            steps{
                // Check out the source code from a Git repository and run 'mvn clean install' to build the Maven project
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/TSM-ArpitSG/Task_5']]])
                bat 'mvn clean install'
            }
        }
    
        // Define the second stage, which is to build a Docker image from the Maven project
        stage('Build docker image'){
            steps{
                script{
                    // Build the Docker image using the 'Dockerfile' in the current directory and tag it with 'arpitsh/devops-integration'
                    bat 'docker build -t arpitsh/devops-integration .'
                }
            }
        }

        // Define the third stage, which is to push the Docker image to a Docker Hub registry
        stage('Push image to Hub'){
            steps{
                script{
                    // Log in to Docker Hub using the 'arpitsh' username and 'dockerhubpwd' password stored as a Jenkins credential
                    withCredentials([string(credentialsId: 'dockerhub-pwd', variable: 'dockerhubpwd')]) {
                        bat 'docker login -u arpitsh -p ${dockerhubpwd}'
                    }
                    // Push the Docker image to the 'arpitsh/devops-integration' repository on Docker Hub
                    bat 'docker push arpitsh/devops-integration'
                }
            }
        }
    }
}

// Code Written by @Arpit Singh 19BCG10069