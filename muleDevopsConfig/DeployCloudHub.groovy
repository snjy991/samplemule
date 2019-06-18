def deployToCloudHub(String JarName){
	println("The run type is "+ env.DEPLOYMENT_TYPE)
	Properties properties = new Properties()
	String branch=GIT_BRANCH
	println("Branch name is ${branch}")
	if (branch.contains("Dev_")){
		File propertiesFile = new File("${workspace}/muleDevopsConfig/dev_env.properties")
		properties.load(propertiesFile.newDataInputStream())
		println("the value of worker"+properties.worker)
		String PATH= "/devops/out/CDScript/working/${BUILD_NUMBER}_${JOB_NAME}/"+JarName
		println (PATH);
		//Based on DEPLOYMENT_TYPE deciding application is already deployed or not
		if(env.DEPLOYMENT_TYPE == "FirstRun"){
		     println("Deploy Application First Time...")
		     withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId:'anypoint-studio-snjy', usernameVariable: 'Username', passwordVariable: 'Password']]) {
                   // jarName=sh (script : 'ls /devops/out/CDScript/working/${BUILD_NUMBER}_${JOB_NAME}/',returnStdout:true)
                    println "jar name ${JarName}"
                    sh """anypoint-cli --username ${Username} --password ${Password} runtime-mgr cloudhub-application deploy --runtime ${properties.runtime} --workers ${properties.worker} --workerSize ${properties.workerSize} --region ${properties.region} --property "username:${Username}" ${env.APPLICATIONNAME} ${PATH} """
                }
							}
	 else{
		 println("Deploy Application....")
		 withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId:'anypoint-studio-snjy', usernameVariable: 'Username', passwordVariable: 'Password']]) {
				 println "jar name ${JarName}"
				 sh """anypoint-cli --username ${Username} --password ${Password} runtime-mgr cloudhub-application modify --runtime ${properties.runtime} --workers ${properties.worker} --workerSize ${properties.workerSize} --region ${properties.region} --property "username:${Username}" ${env.APPLICATIONNAME} ${PATH} """
		 }
	 }
	}
	if (branch.contains("Stage_")){
		println("Deployed in Staging environment")
	}

	if (branch.contains("master")){
		println("Deployed in Production environment")
	}
}
return this
