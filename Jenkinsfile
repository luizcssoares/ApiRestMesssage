pipeline {
<<<<<<< HEAD
      agent any
      environment {
			registry = 'luizcssoares/apirestmessage'
			dockerhub_credentials = 'luizcssoares-dockerhub'   
			KUBE_SA_TOKEN = 'eyJhbGciOiJSUzI1NiIsImtpZCI6InRvWVVweTlCaUpkejlHTFFwY25hLXV6aWEwTzdqdG5FempxQU16TjdUWjAifQ.eyJhdWQiOlsiaHR0cHM6Ly9rdWJlcm5ldGVzLmRlZmF1bHQuc3ZjLmNsdXN0ZXIubG9jYWwiXSwiZXhwIjoxNzU0OTE5MDM2LCJpYXQiOjE3MjMzODMwMzYsImlzcyI6Imh0dHBzOi8va3ViZXJuZXRlcy5kZWZhdWx0LnN2Yy5jbHVzdGVyLmxvY2FsIiwianRpIjoiZmNkOGMzMDYtN2U1Ny00ZTFkLWFiOGItNmNkMDE0MDVkZmUzIiwia3ViZXJuZXRlcy5pbyI6eyJuYW1lc3BhY2UiOiJqZW5raW5zIiwic2VydmljZWFjY291bnQiOnsibmFtZSI6ImplbmtpbnMiLCJ1aWQiOiI1NjFmMjMwYi1lYWNhLTRlMDUtOTI5NS1hNmFjN2I4MmM5OGQifX0sIm5iZiI6MTcyMzM4MzAzNiwic3ViIjoic3lzdGVtOnNlcnZpY2VhY2NvdW50OmplbmtpbnM6amVua2lucyJ9.SYRVcZ4Ph9zMTN0nMy326jVkE_KvKvKR-Z8h-XWlS12U2CeOsHGH4OlSZKXbqfegDSjBiqY3kOrpHLrEPvKqKzbnL6M2p5itPwNCHHNAlcof5kR-01NPBCOp1-Awio9FsDrfVFk7bU-jWoT6AHYSgOpDwVX9b35bykVa2eowVFjv6Uh4sdmJ438IsRyNkWko05iPylDC8vNilhRYMBrkfO0qC2G_VdMs1C3NTklvHBQaAuoiqVOtXjR31QU950lF3ftQ9CIDL9fUDHNzCqUhaarx-xCGsZKDamOWq6_s78QtgwK_RB7nA4lSI6FEj0T26iMj4hi4f8oNuGsNmPsAsw'
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
               kubernetesDeploy(configs: "deployment.yaml","service.yaml")  
             }
          }
		  stage('Result') {
		    steps {
				echo 'Deployed Successfull'
=======
	agent any
	environment {
		registry = 'luizcssoares/apirestmessage'
		dockerhub_credentials = 'luizcssoares-dockerhub'   
		KUBE_SA_TOKEN = 'eyJhbGciOiJSUzI1NiIsImtpZCI6ImlEYkozMnM3R3IwTlo3ekh1Y2xqT0dNVE1QNGZycUNwYVpOaEdQQ0tnSnMifQ.eyJhdWQiOlsiaHR0cHM6Ly9rdWJlcm5ldGVzLmRlZmF1bHQuc3ZjLmNsdXN0ZXIubG9jYWwiXSwiZXhwIjoxNzUxNDY5MzY2LCJpYXQiOjE3MTk5MzMzNjYsImlzcyI6Imh0dHBzOi8va3ViZXJuZXRlcy5kZWZhdWx0LnN2Yy5jbHVzdGVyLmxvY2FsIiwianRpIjoiZjQ0MTQ1OWItNTg1Yy00NzVjLWI1N2QtY2EzZjZlNDQyM2U3Iiwia3ViZXJuZXRlcy5pbyI6eyJuYW1lc3BhY2UiOiJqZW5raW5zIiwic2VydmljZWFjY291bnQiOnsibmFtZSI6ImplbmtpbnMiLCJ1aWQiOiIyYWFlM2NjOC0wMzY0LTQyZjctODljNy0yODM3YmJjYmQ5YzUifX0sIm5iZiI6MTcxOTkzMzM2Niwic3ViIjoic3lzdGVtOnNlcnZpY2VhY2NvdW50OmplbmtpbnM6amVua2lucyJ9.AqJgPLhdtPnrjPCUcNRWLK1Hjr9FxXvfQgP7hcRU1urYhL7-C09sTuexVBb4rrmqI1ds7SL2fXXw9Rt8tx0XUkenDGX6Mh0KCXrf13YWdwIqvuV2mFgdSJHAmrO8fgfefEyQCVJgEWS57qnc71wOPxOUJ0xljAqMYaAFgfwfEKRgICBQ998Vums8JlDmd_xkpfz_36G9DKat7WX45gjK9Dklwm-s4r5NYPPKBRnhZC8ENbS4vkYMxhIM_cwvP5hjlHsyhppTU6_hhHmzdE7p7etKMvaaij6wwipe6rhnISzCRW3J9uV93xNvUGnofDOot1CV8dBtgnRUHL0cTjtYBA'
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
			script {						
				withCredentials([string(credentialsId: 'secrets', variable: KUBE_SA_TOKEN)]) {		
				  sh 'kubectl apply -f deployment.yaml --token='$KUBE_SA_TOKEN' --server=https://127.0.0.1:32771  --insecure-skip-tls-verify'
				}
>>>>>>> b1bb5d281b8c61cf6ae3f120f08d7fe028f97b22
			}
		  }
      }  
}