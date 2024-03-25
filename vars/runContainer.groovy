def call(){
    sh "docker run -d --name youtube1 -p 5000:5000 tejautti/youtube:latest"
}