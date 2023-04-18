pipeline {
    agent any
    parameters {
    choice choices: ['OnBoardingDeveloperStack', 'Dev'], description: 'Select your Choice', name: 'FOLDER_NAME'
  }

    stages {
        stage('Create Job') {
            steps {
                script {
                    
                    jobDsl sandbox: true, scriptText: '''freeStyleJob("${FOLDER_NAME}/${JOB_NAME}") {
                    	
						discardOldBuilds(int daysToKeep = 3, int numToKeep = 3, int artifactDaysToKeep = -1, int artifactNumToKeep = -1)
						
                    	jdk(\'Java 8\')
                    	scm {
                    		github(\'git@bitbucket.org:sohesh/onborddeveloperstack.git\', \'*/dev\')
                    	}
                    	triggers {
                    		githubPush()
                    	}
                    	steps {
                    		shell('cd onbrd_services/')
                    	}
                    	publishers {
                    		archiveArtifacts(\'job-dsl-plugin/build/libs/job-dsl.hpi\')
                    	}
                    }'''
					
                }
            }
        }
    }
}
