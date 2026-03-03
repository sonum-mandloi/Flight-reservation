pipeline{
  agent any
  stages{
    stage ("code-pull"){
      step{
        git branch: 'main', url: 'https://github.com/sonum-mandloi/Flight-reservation.git'
      }
    }
  }
}
