node {   
      stage('Build MVN') {	
	    steps{
		  sh 'https://github.com/luizcssoares/ApiRestMessage.git' 
		  sh 'mvn --version' 
		  sh 'mvn package -Dmaven.test.skip=true'              
	    }     
      }
  }
