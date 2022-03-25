def call(String dockerimage,String Path){
    image = dockerimage.toLowerCase()
    createdimage = docker.build(image," --no-cache  ${Path}")

     docker.withRegistry( '', registryCredential ) {
          createdimage.push('latest')
          createdimage.push("${env.BUILD_NUMBER}")
}
}
