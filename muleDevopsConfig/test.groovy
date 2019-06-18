def testfun(String commit_id, String buidpath){
 def proc = "git diff-tree --no-commit-id --name-only -r ${commit_id}".execute()
  def b = new StringBuffer()
  proc.consumeProcessErrorStream(b)
 println "output is ${proc}"
}
return this
