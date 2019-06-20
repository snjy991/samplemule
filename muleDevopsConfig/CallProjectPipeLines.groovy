def decideProjectPipeLineCall(List<String> mylist){
  for(int i=0 ;i<mylist.size();i++){
    if(mylist[i]=="Example1-master"){
      build job : 'MuleApplicationCICDPipeline', wait:true, propagate:true
    }
    if(mylist[i]=="samplesan"){
      build job : 'SampleApplicationCICDPipeline', wait:true, propagate:true
    }
  }

}
return this
