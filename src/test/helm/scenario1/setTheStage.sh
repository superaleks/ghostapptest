helm repo add bitnami https://charts.bitnami.com/bitnami
helm install my-release \
  --set ghostBlogTitle=Aleksandra \
    bitnami/ghost