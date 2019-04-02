pipeline {
  agent any
  stages {
    stage('teste') {
      steps {
          sh '''
echo $GIT_COMMIT
TESTE=$(git show-ref --tags -d | grep $GIT_COMMIT | awk '{split($0,a,"/"); print a[3]}')
echo $TESTE
          '''
        }
      }
    }
}
