#!/usr/bin/env groovy
def call(String imageName){
    echo "building the docker image"
    withCredentials([usernamePassword(credentialsId: 'ba245a61-f0b0-4e98-abaa-07a439f7b470', passwordVariable: 'PAS', usernameVariable: 'USER')]){
        sh "docker build -t $imageName ."
        sh "echo $PAS | docker login -u $USER --password-stdin "
        sh "docker push $imageName"
    }
}