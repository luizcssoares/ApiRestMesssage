node {   
      stage('GIT push') {		  
	 git url: "https://github.com/luizcssoares/ApiRestMessage.git"
      }
      stage('Build MVN') {		  
	 bat 'mvn clean package'     
      }	
      stage('DockerHub'){
	 bat 'docker build -t luizcssoares/apirestmessage .'
      }
      stage('Push Docker image'){
	 bat 'docker push luizcssoares/apirestmessage .'
      }	
      stage('Kubernetes'){
	 bat 'kubectl apply -f deployment.yml'
      }		
  }
