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
	         	//List<String> sourceChanged = sh(returnStdout: true, script: "git diff --name-only origin/master..${env.GIT_BRANCH}").split()
          //sourceChanged = sh(returnStdout: true, script: "git diff --name-only origin/master..${env.GIT_BRANCH}")
            //println("the diff branch o/p "+sourceChanged)
			  List<String> sourceChanged =sh(returnStdout: true, script: "git diff-tree --no-commit-id --name-only -r $COMMITID").split()
			   //println("the chages are"+sourcec)
         List<String> change=[]
         List<String> uniqueList=[]
			    for (int i = 0; i < sourceChanged.size(); i++) {
				   change.add(sourceChanged[i].split("/")[0])
			    }
          uniqueList= change.unique()
 			    for (int i = 0; i < uniqueList.size(); i++) {
 				   println(i+"th element is "+uniqueList[i])
 			    }
              }
                }
            }
        }

}
