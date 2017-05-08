pipeline {
  agent any
  stages {
    stage('prepare') {
      steps {
        echo 'print this in prepare section - springboot jenkins file'
	echo 'PR test'
        sh 'echo \'hello sh\''
      }
    }
    stage('build') {
      steps {
        git(url: 'https://github.com/Chandan-Nayak/springboot', branch: 'master', changelog: true)
        fileExists 'pom.xml'
      }
    }
    stage('post') {
      steps {
        echo 'lets build it later'
      }
    }
  }
}
