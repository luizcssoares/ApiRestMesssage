pipeline {
      agent any
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
	      stage('Login') {
		      steps {
			   bat 'echo $DOCKERHUB_CREDENTIALS | docker login -u $DOCKERHUB_CREDENTIALS --password-stdin'
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
