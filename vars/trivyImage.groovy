def call() {
    sh 'trivy image tejautti/youtube:latest > trivyimage.txt'
}