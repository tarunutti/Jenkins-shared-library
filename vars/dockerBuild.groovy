def call(String dockerHubUsername, String imageName) {
    // Build the Docker image
    sh "docker build --build-arg REACT_APP_RAPID_API_KEY=985e1f0b5cmsh1a4ec74fca6073dp15cd47jsnfbb794966c15g -t ${imageName} ."
     // Tag the Docker image
    sh "docker tag ${imageName} ${dockerHubUsername}/${imageName}:latest"
    // Push the Docker image

    withCredentials([usernamePassword(credentialsId: 'Docker', passwordVariable: 'pass', usernameVariable: 'user')]) {
     sh "docker login -u '$USER' -p '$PASS'"
      sh "docker push ${dockerHubUsername}/${imageName}:latest"
}
}



def call(String project, String ImageTag, String hubUser){
//     withCredentials([usernamePassword(
//             credentialsId: "docker",
//             usernameVariable: "USER",
//             passwordVariable: "PASS"
//     )]) {
//         sh "docker login -u '$USER' -p '$PASS'"
//     }
//     sh "docker image push ${hubUser}/${project}:${ImageTag}"
//     sh "docker image push ${hubUser}/${project}:latest"   
// }