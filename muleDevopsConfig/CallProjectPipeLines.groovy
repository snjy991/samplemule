def decideProjectPipeLineCall(List<String> mylist, String Commit_id){
  for(int i=0 ;i<mylist.size();i++){
    if(mylist[i]=="Example1-master"){
      build job : 'MuleApplicationCICDPipeline',parameters:[[$class: 'StringParameterValue', name: 'commit_id', value:"$Commit_id"]], wait:true, propagate:true
    }
    if(mylist[i]=="samplesan"){
      build job : 'SampleApplicationCICDPipeline', parameters:[[$class: 'StringParameterValue', name: 'commit_id', value:"$Commit_id"]], wait:true, propagate:true
    }
  }

}
return this
