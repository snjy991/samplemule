def getBranchName(){
  def branch=GIT_BRANCH;
  def finalbranch=branch.tokenize("/");
  List<String> tokenizebranch=[]
  def temp1= finalbranch[1].tokenize("_")
  def temp2= temp1[1].tokenize("-")
  def releaseno= temp2[0]
  def usersto=temp2[1]
  tokenizebranch.add(releaseno)
  tokenizebranch.add(usersto)
  tokenizebranch.add(finalbranch[1])
  return tokenizebranch
}
return this
