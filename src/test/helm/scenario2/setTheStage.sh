helm repo add bitnami https://charts.bitnami.com/bitnami
helm install my-release \
  --set ghostBlogTitle=aleksandraqa \
  --set ghostUsername=aleksandra,ghostPassword=goodToBeAlive123 \
  --set ghostPath=localhost  \
  --set service.type=LoadBalancer  \
  --set ghostHost=localhost  \
  --set ghostPassword=test \
  --set mariadb.auth.rootPassword=test \
  --set mariadb.auth.password=test
    bitnami/ghost