helm repo add bitnami https://charts.bitnami.com/bitnami
helm install my-release \
  --set ghostBlogTitle=Aleksandra \
  --set ghostPath=localhost  \
  --set service.type=LoadBalancer  \
  --set ghostHost=localhost  \
  --set ghostPassword=test \
  --set mariadb.auth.rootPassword=test \
  --set mariadb.auth.password=test
    bitnami/ghost
