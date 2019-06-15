def getBranchName(){
  def branch=GIT_BRANCH;
  def finalbranch=branch.tokenize("/");
  return finalbranch[1]
}
return this
