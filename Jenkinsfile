

pipeline{
        agent any
        stages{
            stage("Test stage - File"){
                steps{
                    script{
                         kashi()
                         println "Pipelines: " + currentBuild.changeSets
                    }
                }
            }
        }
    }
