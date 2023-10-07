pipeline {
      agent any
      environment {
	 registry = 'luizcssoares/apirestmessage'
         dockerhub_credentials = 'luizcssoares-dockerhub'
	 nexus_credentials = 'nexus-user-credentials'     
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
              stage ('Deploy NEXUS'){
		    steps {
			    script {
				echo "pushing NEXUS "    				                          
				docker.withRegistry('http://localhost:8023/repository/docker-api-message', nexus_credentials) {
                                   docker_image.push('latest')
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
