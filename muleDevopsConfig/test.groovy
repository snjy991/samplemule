def testfun(String commit_id){
 def proc = "git diff-tree --no-commit-id --name-only -r ${commit_id}".execute()
  def b = new StringBuffer()
  proc.consumeProcessErrorStream(b)
  println proc.text
 println "Workespace ${workspace}"
  new File('E:/','Example.txt').withWriter('utf-8') { 
         writer -> writer.writeLine 'Hello World' 
}
return this
