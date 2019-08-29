pipeline {
  agent any
  stages {
    stage('checkout') {
      steps {
        checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/narasimhavuppala/jenkins-calculator.git']]])
        echo 'checkout stage'
      }
    }
    stage('Build') {
      steps {
        bat 'mvn -T 3 clean install'
        echo 'Build stage'
      }
    }
    stage('Aprove') {
      input {
        message 'Should we continue?'
        id 'Yes, we should.'
        submitter 'Anitha s,bob'
        parameters {
          string(name: 'PERSON', defaultValue: 'Mr Jenkins', description: 'Who should I say hello to?')
        }
      }
      steps {
        echo "Hello, ${PERSON}, nice to meet you."
      }
    }
    stage('publish Junit') {
      steps {
        cobertura(coberturaReportFile: 'target/site/cobertura/coverage.xml', conditionalCoverageTargets: '70, 0, 0', lineCoverageTargets: '80, 0, 0', methodCoverageTargets: '80, 0, 0', sourceEncoding: 'ASCII')
        echo 'Unit stage'
      }
    }
    stage('parallel') {
      parallel {
        stage('coverage') {
          steps {
            echo 'coverage stage'
          }
        }
        stage('pmd') {
          steps {
            echo 'pmd stage'
          }
        }
      }
    }
  }
  tools {
    maven 'Maven3'
  }
  post {
    always {
      echo 'reached post section'

    }

  }
  options {
    timeout(time: 1, unit: 'HOURS')
  }
  parameters {
    string(name: 'PERSON', description: 'Who should I say hello to?')
    booleanParam(name: 'DEBUG_BUILD', description: '')
  }
  triggers {
    cron('H */4 * * 1-5')
  }
}