node {   
      stage('GIT push') {		  
	 git url: "https://github.com/luizcssoares/ApiRestMessage.git"
      }
      stage('Build MVN') {		  
	 bat 'mvn clean package'     
      }	
      stage('Docker image'){
	 bat 'docker build -t luizcssoares/apirestmessage .'
      }
  }
