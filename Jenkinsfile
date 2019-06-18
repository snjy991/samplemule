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
	         sh """ #!/bin/bash
		        git diff-tree --no-commit-id --name-only -r $COMMITID | tee $BUILD_PATH"""
              }
                }
            }
        }

}
