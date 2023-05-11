pipeline {
    agent any
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
                          github(\'sohesh/onborddeveloperstack\', \'*/dev\', String protocol = \'ssh\', String host = \'bitbucket.org\')
                          
                        }
                        wrappers {
                            nodejs('NodeJS')
                            environmentVariables {
                                env(\'PATH\', \'$PATH:/var/lib/jenkins/.serverless/bin\')
                            }
                        }
                        steps {
                    		shell('cd onbrding_Service/ \\nnpm install \\nserverless-package-python-functions \\nnpm install serverless-package-delete-loggroups \\nenv')
                    	}
                    
                    }'''
					
                }
            }
        }
    }
}
