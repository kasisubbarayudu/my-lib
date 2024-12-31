

pipeline{
        agent any
        stages{
            stage("Test stage - File"){
                steps{
                    script{
                         kashi()
                         println "This statement has been added to trigger the changeset"
                    }
                }
            }
            stage("Changeset"){
             when{
               changeset "**/README.md"
             }
             steps{
               script{
                  println "The change was triggered.."
               }
             }
           }
        }
    }
