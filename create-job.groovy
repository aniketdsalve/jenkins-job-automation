import jenkins.model.*
import hudson.model.*

def jenkins = Jenkins.getInstance()

// Create a new Freestyle project
def job = jenkins.createProject(FreeStyleProject, 'My New Job')

// Set the build parameters
job.setDescription('This is my new Jenkins job')
job.setJdk('JDK 11')
job.setAssignedLabel(jenkins.getSelfLabel())

// Add a build step
job.getBuildersList().add(new Shell("echo 'Hello, World!'"))

// Save the job configuration
job.save()
