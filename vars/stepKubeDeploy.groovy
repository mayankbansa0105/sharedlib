def call(String DeployName,int port,String imageName){
       String  Image = imageName
sh """ echo "updating Deployfile"
       yq eval -i \'.spec.template.spec.containers[0].image = "${Image}:${env.BUILD_NUMBER}"\' Deploy.yaml
       yq eval -i \'.metadata.name = "${DeployName}"\' Deploy.yaml """
    script {
         kubernetesDeploy configs: 'Deploy.yaml', kubeconfigId: 'kube-config'
        }
}
