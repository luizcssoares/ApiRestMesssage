pipeline {
      agent any
      environment {
			registry = 'luizcssoares/apirestmessage'
			dockerhub_credentials = 'luizcssoares-dockerhub'   
			KUBE_SA_TOKEN = 'eyJhbGciOiJSUzI1NiIsImtpZCI6InRvWVVweTlCaUpkejlHTFFwY25hLXV6aWEwTzdqdG5FempxQU16TjdUWjAifQ.eyJhdWQiOlsiaHR0cHM6Ly9rdWJlcm5ldGVzLmRlZmF1bHQuc3ZjLmNsdXN0ZXIubG9jYWwiXSwiZXhwIjoxNzUyNTA4MzE1LCJpYXQiOjE3MjA5NzIzMTUsImlzcyI6Imh0dHBzOi8va3ViZXJuZXRlcy5kZWZhdWx0LnN2Yy5jbHVzdGVyLmxvY2FsIiwianRpIjoiY2U5NGExM2UtNDNiZC00NTNkLWI5YTUtOWI0ZTYzNjY0NWYwIiwia3ViZXJuZXRlcy5pbyI6eyJuYW1lc3BhY2UiOiJqZW5raW5zIiwic2VydmljZWFjY291bnQiOnsibmFtZSI6ImplbmtpbnMiLCJ1aWQiOiI1NjFmMjMwYi1lYWNhLTRlMDUtOTI5NS1hNmFjN2I4MmM5OGQifX0sIm5iZiI6MTcyMDk3MjMxNSwic3ViIjoic3lzdGVtOnNlcnZpY2VhY2NvdW50OmplbmtpbnM6amVua2lucyJ9.TCefuSoOOqpL7wNKgPis05nDzZkqmcVcmNYeV5hoC2ofFU_MZwh8r8nQRdOP46IAG2YqesVlJnjCzlukWa1qQPY1Od5zyXJq2UMNPdlimyedqlIqBgmLtP15r_a-l4XbfzxYtFsi-kb6EwQsVaYWzpCup5Aj_M1qhHN1lCAif4dZQU3gzFnpjgVo2_hYQ_VEYs7qWbp5_2rgs8nmgELVDpC4NYbk5gLIqk4uNwMbZRTa2EzS6OJMXj1l4vx_QgHuTBORCn1VePwzQPZ_m64qkHrjK9oDAYFPcR9P4s3p1UMN6_DP7bw8XeXsY2o3TdCFFXyJRxjiNrS1VAw4Hz-f_g'
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
		           sh 'mvn -B -DskipTests clean package'     
		      }
	      }	
	      stage('Docker Build'){
		      steps{
			   script {		
				   docker_image = docker.build  registry
			    }
		      }
	      }	  
	      stage('Deploy Docker Hub') {
		      steps{
			    script {
				    docker.withRegistry( '', dockerhub_credentials ) {
			                //docker_image.push('$BUILD_NUMBER')
			                docker_image.push('latest')			
			            }				  				
			    }
		      }
	       }	     
		  		
		   stage('Deploy to Minikube') {
            steps {
                // Apply Kubernetes deployment using the Kubernetes service account
                withCredentials([string(credentialsId: 'jenkins-secrets', variable: KUBE_SA_TOKEN)]) {
                    //bat 'kubectl apply -f deployment.yaml --token=$KUBE_SA_TOKEN --server=https://127.0.0.1:65173 --insecure-skip-tls-verify=true --validate=false'
					sh 'kubectl apply -f deployment.yaml --validate=false'
					//bat 'kubectl port-forward service/apimessage 54083:31146' 
					//bat 'kubectl apply -f deployment.yaml --token=$KUBE_SA_TOKEN --server=https://127.0.0.1:54840 --insecure-skip-tls-verify=true --validate=false'
                 }
             }
          }
		  stage('Result') {
		    steps {
				echo 'Deployed Successfull'
			}
		  }
      }  
}