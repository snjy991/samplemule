pipeline{
    agent any
        stages{
            stage("Getting Build Information"){
                steps{
                    script{
                    sh "git rev-parse --short HEAD> .git/commit-id"
                    def commit_id= readFile('.git/commit-id')
                    BUILD_PATH = "/devops/out/CDScript/working/buildconf.txt"
			              build job: 'git', parameters: [[$class: 'StringParameterValue', name: 'buildpath', value: "$BUILD_PATH"] [$class: 'StringParameterValue', name: 'commit_id', value="$commit_id"]], wait: true, propagate: true
              }
                }
            }
        }

}
