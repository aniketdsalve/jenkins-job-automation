import jenkins.model.*
import jobXml from create-jobXml

pipeline {
    agent { node { label 'slave-1' } }

    stages {
        stage('Clean Workspace') {
            steps {
                cleanWs()
            }
        }
        
        stage('create job') {
            
            steps {
              
                script {
                    
                    echo "Current workspace is ${env.WORKSPACE}"
                   
                    Jenkins jenkins = Jenkins.instance
                    
                    def jobName = params.jobName
                    
                      // Set the job name and description
                        
                    def jobDescription = 'This is demo-job1 created by Jenkinsfile'
                    
                    // Define the job configuration XML
                    //def jobXml = jobXml

                    // Check if the job exists
                    if (jenkins.getItem(jobName) == null) {
                        println "The '${jobName}' job does not exist."
                        
                      
                        // Create the job
                        
                        def xmlStream = new ByteArrayInputStream(jobXml.getBytes())
                        
                        jenkins.createProjectFromXML(jobName, xmlStream)
                        //jenkins.createProject(jobName, jobLocation)
                        
                        // Print a message
                        println "Created the '${jobName}' job successfully" 
                        
                        
                        
                    } else {
                       
                        println "The '${jobName}' job already exists."
                    }   
                }
            }
        }
    }
}
    
