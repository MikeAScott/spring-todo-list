pipeline {
   agent {
        docker { image 'maven:3-openjdk-11' }
    }

   stages {
      stage('Build') {
         steps {
            // Run Maven on a Unix agent.
            sh "mvn clean package"
         }

         post {
            always {
               junit '**/target/surefire-reports/TEST-*.xml'
            }
            success {
               archiveArtifacts 'target/*.war'
            }
         }
      }
   }
}