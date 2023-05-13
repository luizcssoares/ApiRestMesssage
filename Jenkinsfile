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
		           bat 'mvn clean package'     
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
			          docker.withRegistry( '', dockerhub_credentials ) {
			              docker_image.push()
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
