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
		           bat 'docker build -t luizcssoares/apirestmessage .'
		      }
	      }	  	      	      
	      stage('Deploy our image') {
		      steps{
			script {
			    docker.withRegistry( '', 'luizcssoares/apirestmessage' ) {
			       dockerImage.push()
			    }
			}
		      }
	      }	      
	      stage('Kubernetes'){
		      steps {
		           bat 'kubectl apply -f deployment.yml'
		      }
	      }	        
      }  
}
