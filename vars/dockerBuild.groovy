def call(String dockerHubUsername, String imageName) {
    // Build the Docker image
    sh "docker build --build-arg REACT_APP_RAPID_API_KEY=985e1f0b5cmsh1a4ec74fca6073dp15cd47jsnfbb794966c15 -t ${imageName} ."
     // Tag the Docker image
    sh "docker tag ${imageName} ${dockerHubUsername}/${imageName}:latest"
    // Push the Docker image
   withDockerRegistry(credentialsId: 'Docker', toolName: 'Docker', url: 'https://hub.docker.com/') {
     sh "docker push ${dockerHubUsername}/${imageName}:latest"
    
 }

}