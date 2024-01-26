pipeline {
      agent any
      environment {
	 registry = 'luizcssoares/apirestmessage'
         dockerhub_credentials = 'luizcssoares-dockerhub'     
	 docker_image = ''     
      }	 
      stages {		    
	      stage('GIT pull') {
		      steps{  
			    git url: "https://github.com/luizcssoares/ApiRestMessage.git"
		      }				   		      
	      }
	      stage('Build Maven') {		
		      steps {
		           bat 'mvn -B -DskipTests clean package'     
		      }
	      }	
	      stage('Docker Build'){
		      steps{
			   script {		
				   docker_image = docker.build  registry
			    }
		      }
	      }	  
	      stage('Deploy Git Hub') {
		      steps{
			    script {
				    docker.withRegistry( '', dockerhub_credentials ) {
			                docker_image.push("$BUILD_NUMBER")
			                docker_image.push('latest')			
			            }				  				
			    }
		      }
	      }	               	      	     
	      stage('Implantacao Kubernetes'){
		      steps {
		           sh 'kubectl apply -f deployment.yml'
		      }
	      }	        
      }  
}
