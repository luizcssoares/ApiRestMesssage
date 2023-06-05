pipeline {
      agent any
      environment {
	 registry = 'luizcssoares/apirestmessage'     
         dockerhub_credentials = 'luizcssoares-dockerhub'
	 docker_image = ''     
      }	 
      stages {	
	      stage('GIT push') {
		      steps{  
		           git url: "https://github.com/luizcssoares/ApiRestMessage.git"
		      }
	      }
	      stage('Build Maven') {		
		      steps {
		           sh 'mvn clean package'     
		      }
	      }	
	      stage('Docker Build'){
		      steps {			      			      			      
			      script {     
			            docker_image = docker.build registry + ":$BUILD_NUMBER"		
			      }
		      }
	      }	  	      	      
	      stage('Deploy our image') {
		      steps{  
			      script {
				 echo "pushing " + docker_image
				      docker.withRegistry( '', dockerhub_creentials ) {
					 docker_image.push()
				      }
				 echo "pushed"
			      }
		      }
	      }	      
	      stage('Kubernetes'){
		      steps {
		           sh 'kubectl apply -f deployment.yml'
		      }
	      }	        
      }  
}
