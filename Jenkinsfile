pipeline {
  agent any
  stages {
    stage('Source Code') {
      steps {
        bat 'echo hello world'
      }
    }
    stage('Building') {
      steps {
        bat 'echo build'
      }
    }
    stage('Approval') {
      steps {
        input 'Approve'
      }
    }
  }
}