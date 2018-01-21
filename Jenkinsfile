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
    stage('Deploy to SIT') {
      steps {
        input 'Yes'
      }
    }
    stage('Approve') {
      steps {
        input 'Deploiy to UAT'
      }
    }
  }
}