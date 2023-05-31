pipeline {
    agent { label 'master' }
    
    parameters {
    choice(name: 'FOLDER_NAME', choices: ['OnBoardingDeveloperStack', 'Dev'], description: 'Select your Choice')
    string(name: 'JOB_NAME', defaultValue: 'DEMO-', description: 'Please enter Job Name.', trim: true)
  }
    stages {
        stage('Create Job') {
            steps {
                script { 
  
                    jobDsl sandbox: true, scriptText: '''freeStyleJob("${FOLDER_NAME}/${JOB_NAME}") {
                    	
					    logRotator {
                            numToKeep(3)
                            daysToKeep(3)
                        }

                    	scm {
                          github(\'git@bitbucket.org:sohesh/onborddeveloperstack.git\', \'*/dev\')
                        }
                        
                        wrappers {
                            nodejs('NodeJS')
                        }
                        
                        environmentVariables {
                            keepBuildVariables(false)
                            keepSystemVariables(false)
                            env('Properties Content', 'PATH=$PATH:/var/lib/jenkins/.serverless/bin')
                        }

                    	steps {
                    		shell('cd ${PATH_DETAILS}/ \\nnpm install \\nserverless-package-python-functions \\nnpm install serverless-package-delete-loggroups \\nenv')
                    	}
                    
                    }'''
					
                }
            }
        }
    }
}
