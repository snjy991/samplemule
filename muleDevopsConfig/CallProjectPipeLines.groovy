def decideProjectPipeLineCall(List<String> mylist){
  for(int i=0 ;i<mylist.size()){
    if(mylist[i]=="Example1-master"){
      buid job =: 'MuleApplicationCICDPipeline', wait:true, propagate:true
    }
    if(mylist[i]=="samplesan"){
      buid job =: 'SampleApplicationCICDPipeline', wait:true, propagate:true
    }
  }

}
return this
