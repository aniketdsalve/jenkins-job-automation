import jenkins.model.*


pipeline {
    agent { node { label 'slave-1' } }

    stages {
        stage('Clean Workspace') {
            steps {  cleanWs()  }
        }
        
        stage('check folder'){
            steps{
                sh 'mkdir Dev'
            }
        }
        stage('create job') {
            steps {
                script {
                    
                    echo "Current workspace is ${env.WORKSPACE}"
                   
                    Jenkins jenkins = Jenkins.instance
                    
                    // Set the job name and description
                    def jobName = params.jobName
                    def jobDescription = 'This is demo-job1 created by Jenkinsfile'
                    def gitUrl = 'https://github.com/aniketdsalve/aniketdsalve.github.io.git'
                    def branchName = '*/main'
                    
                    // Define the job configuration XML
                      jobXml = """
                        <project>
                            <description>${jobDescription}</description>

                            <scm class="hudson.plugins.git.GitSCM" plugin="git@3.3.2">
                            <configVersion>1</configVersion>
                            <userRemoteConfigs>
                                <hudson.plugins.git.UserRemoteConfig>
                                <url>${gitUrl}</url>
                                </hudson.plugins.git.UserRemoteConfig>
                            </userRemoteConfigs>

                            <branches>
                                <hudson.plugins.git.BranchSpec>
                                <name>${branchName}</name>
                                </hudson.plugins.git.BranchSpec>
                            </branches>

                            <doGenerateSubmoduleConfigurations>false</doGenerateSubmoduleConfigurations>
                            <submoduleCfg class="list"/>
                            <extensions/>
                            </scm>

                            <builders>
                                <hudson.tasks.Shell>
                                    <command>echo 'Hello, world!'</command>
                                </hudson.tasks.Shell>
                            </builders>
                        </project>
                    """



                    // Check if the job exists
                    if (jenkins.getItem(jobName) == null) {
                        println "The '${jobName}' job does not exist."
                
                        // Create the job
                        def xmlStream = new ByteArrayInputStream(jobXml.getBytes())        
                        jenkins.createProjectFromXML(jobName, xmlStream)
                        
                        
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
    
