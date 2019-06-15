def deployToCloudHub(String JarName, String envType){
	Properties properties = new Properties()
	if (envType=="Dev"){
		File propertiesFile = new File("${workspace}/muleDevopsConfig/dev_env.properties")
		properties.load(propertiesFile.newDataInputStream())
		println("the value of worker"+properties.worker)
		String PATH= "/devops/out/CDScript/working/${BUILD_NUMBER}_${JOB_NAME}/"+JarName
		println (PATH);
		if(env.DEPLOYMENT_TYPE == "FirstRun"){
								withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId:'anypoint-studio-snjy', usernameVariable: 'Username', passwordVariable: 'Password']]) {
                   // jarName=sh (script : 'ls /devops/out/CDScript/working/${BUILD_NUMBER}_${JOB_NAME}/',returnStdout:true)
                    println "jar name ${JarName}"
                    sh """anypoint-cli --username ${Username} --password ${Password} runtime-mgr cloudhub-application deploy --runtime ${properties.runtime} --workers ${properties.worker} --workerSize ${properties.workerSize} --region ${properties.region} --property "username:${Username}" ${env.APPLICATIONNAME} ${PATH} """
                }
							}
	 else{
			println("general deploymnent")
	 }
	}
}
return this
