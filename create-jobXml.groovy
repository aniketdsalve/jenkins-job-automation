import groovy.transform.Field

@Field
def jobXml = """
                        <project>
                            <description>${jobDescription}</description>
                            <scm class="hudson.plugins.git.GitSCM" plugin="git@3.3.2">
                            <configVersion>1</configVersion>
                            <userRemoteConfigs>
                                <hudson.plugins.git.UserRemoteConfig>
                                <url>https://github.com/peterjenkins1/jenkins-scripts/</url>
                                </hudson.plugins.git.UserRemoteConfig>
                            </userRemoteConfigs>
                            <branches>
                                <hudson.plugins.git.BranchSpec>
                                <name>*/master</name>
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
return this;
