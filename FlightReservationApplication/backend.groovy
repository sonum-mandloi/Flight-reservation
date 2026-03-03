pipeline{
  agent any
  stages{
    stage ("code-pull"){
      steps{
        git branch: 'main', url: 'https://github.com/sonum-mandloi/Flight-reservation.git'
      }
    }
    stage('build){
          steps{
            cd FlightReservastionApplication
            sh 'mvn clean package'
          }
    }
  }
}

