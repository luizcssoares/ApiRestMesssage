pipeline {
      environment {
         DOCKERHUB_CREDENTIALS = credentials('luizcssoares-dockerhub')
      }	 
      stages {	
	      stage('GIT push') {
		      steps{  
		           git url: "https://github.com/luizcssoares/ApiRestMessage.git"
		      }
	      }
	      stage('Build Maven') {		
		      steps {
		           bat 'mvn clean package'     
		      }
	      }	
	      stage('Docker Build'){
		      steps {
		           bat 'docker build -t luizcssoares/apirestmessage:latest .'
		      }
	      }
	      stage('DockerHub Login'){
		      steps {
		           bat 'docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
		      }
	      }	
	      stage('Push DockerHub'){
		      steps {
		           bat 'docker push luizcssoares/apirestmessage:latest'
		      }
	      }	
	      stage('Kubernetes'){
		      steps {
		           bat 'kubectl apply -f deployment.yml'
		      }
	      }	        
      }  
}
