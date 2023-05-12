pipeline {
      enviroments {
         DOCKERHUB_CREDENTIALS = credentials('luizcssoares-dockerhub')
      }	 
      stages {	
	      stage('GIT push') {		  
		 git url: "https://github.com/luizcssoares/ApiRestMessage.git"
	      }
	      stage('Build Maven') {		  
		 bat 'mvn clean package'     
	      }	
	      stage('Docker Build'){
		 bat 'docker build -t luizcssoares/apirestmessage:latest .'
	      }
	      stage('DockerHub Login'){
		 bat 'docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
	      }	
	      stage('Push DockerHub'){
		 bat 'docker push luizcssoares/apirestmessage:latest'
	      }	
	      stage('Kubernetes'){
		 bat 'kubectl apply -f deployment.yml'
	      }	        
      }  
}
