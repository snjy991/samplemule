pipeline{
    agent any
        stages{
            stage("Getting Build Information"){
                steps{
                    script{
                    sh "git rev-parse --short HEAD> .git/commit-id"
                    COMMITID= readFile('.git/commit-id')
                    BUILD_PATH = "/devops/out/CDScript/working/buildconf.txt"
	           //build job: 'git', parameters: [[$class: 'StringParameterValue', name: 'buildpath', value: "$BUILD_PATH"],[$class: 'StringParameterValue', name: 'commit_id', value:"$COMMITID"]], wait: true, propagate: true
	         	List<String> sourceChanged = sh(returnStdout: true, script: "git diff --name-only origin/master..${env.GIT_BRANCH}").split()
			   List<String>changed
			   
			    for (int i = 0; i < sourceChanged.size(); i++) {
				   changed.add(sourceChanged[i].split("/")[0])
			    }
			    for (int j = 0; j < changed.size(); j++) {
				   changed.add(changed[j])
			    }
              }
                }
            }
        }

}
