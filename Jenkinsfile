pipeline{
    agent any
    
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
    tools {
        maven 'Maven3' 
    }
    
    stages{
        stage('checkout'){
            steps {
                checkout poll: false, scm: [$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/narasimhavuppala/jenkins-calculator.git']]]

                echo 'checkout stage'
            }
        }
        stage('Build'){
            
            steps {
               bat 'mvn clean install'

                echo 'Build stage'
            }
        }
         stage('Aprove') {
            input {
                message "Should we continue?"
                ok "Yes, we should."
                submitter "Anitha s,bob"
                parameters {
                    string(name: 'PERSON', defaultValue: 'Mr Jenkins', description: 'Who should I say hello to?')
                }
            }
            steps {
                echo "Hello, ${PERSON}, nice to meet you."
            }
        }

        stage('publish Junit'){
            
            steps {
                cobertura autoUpdateHealth: false, autoUpdateStability: false, coberturaReportFile: 'target/site/cobertura/coverage.xml', conditionalCoverageTargets: '70, 0, 0', failUnhealthy: false, failUnstable: false, lineCoverageTargets: '80, 0, 0', maxNumberOfBuilds: 0, methodCoverageTargets: '80, 0, 0', onlyStable: false, sourceEncoding: 'ASCII', zoomCoverageChart: false

                
                echo 'Unit stage'
            }
        }
        stage('parallel'){
			parallel{
			
				stage('coverage'){
				
					steps{
						echo 'coverage stage'
					}
				}
				stage('pmd'){
				
					steps{
						echo 'pmd stage'
					}
				}
			
			}
            
        }
        
        
        
    } //end of stages
    post{
        always{
            
            echo 'reached post section'
        }
        
    }
    
}
