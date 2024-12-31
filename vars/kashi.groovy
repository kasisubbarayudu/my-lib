import java.io.*
import groovy.io.*

@NonCPS
def call(){
   def dir = new File(pwd())
   
   println "dir path is: ${dir.path}"
   int count = 0 
   new File(dir.path + "/releasenotes.txt").withWriter("utf-8", {writer ->
        dir.eachFileRecurse(FileType.ANY, {file -> 
        count = count + 1
        writer.writeLine("File name is: ${file.name} ${file.isDirectory()}") 
        // println "File name is : ${file.name} ${file.isDirectory()}"
        })
   })
   println currentBuild.changeSets
   for (change in currentBuild.changeSets){
    def entries = change.items
    for (entry in entries){ 
      echo "${entry.commitId} by ${entry.author} on ${new Date(entry.timestamp)}: ${entry.msg}"
      for (file in entry.affectedFiles){
         echo "${file.editType.name} - ${file.path}"
      }
    }
 }
}
