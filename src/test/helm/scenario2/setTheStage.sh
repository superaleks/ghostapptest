helm repo add bitnami https://charts.bitnami.com/bitnami
helm install my-release \
  --set ghostUsername=aleksandra,ghostPassword=goodToBeAlive123 \
    bitnami/ghost