pipeline {
   agent any


   environment {
       IMAGE_NAME = "phucitdev/learnspace:latest"
   }


   stages {


       stage('Checkout') {
           steps {
               git branch: 'main', url: 'https://github.com/pcodeJStack/learnspacejavaspring.git'
           }
       }


       stage('Build Maven') {
           steps {
               sh '''
               chmod +x mvnw
               ./mvnw clean package -DskipTests
               '''
           }
       }


       stage('Build Docker Image') {
           steps {
               sh '''
               docker build -t $IMAGE_NAME .
               '''
           }
       }


       stage('Push Docker Hub') {
           steps {
               withCredentials([usernamePassword(credentialsId: 'dockerhub', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
                   sh '''
                   echo $PASS | docker login -u $USER --password-stdin
                   docker push $IMAGE_NAME
                   '''
               }
           }
       }


       stage('Deploy to VPS') {
           steps {
               sh '''
               ssh -o StrictHostKeyChecking=no root@165.22.245.81 "
                   cd /opt/app &&
                   docker compose pull backend &&
                   docker compose up -d backend
               "
               '''
           }
       }
   }
}
