def getBranchName(){
  def branch=GIT_BRANCH;
  def finalbranch=branch.tokenize("/");
  println(finalbranch[1])
}
return this
