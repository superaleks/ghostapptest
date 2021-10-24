### FIRST TEST SCENARIO
### STEP 1 - CREATE NETWORK
docker network create ghost-network

### STEP 2 - CREATE PERSISTENT VOLUME MARIADB
docker volume create --name mariadb_data
docker run -d --name mariadb \
  --env ALLOW_EMPTY_PASSWORD=yes \
  --env MARIADB_USER=bn_ghost \
  --env MARIADB_PASSWORD=bitnami \
  --env MARIADB_DATABASE=bitnami_ghost \
  --network ghost-network \
  --volume mariadb_data:/bitnami/mariadb \
  bitnami/mariadb:latest

### STEP 3 - CREATE VOLUME FOR GHOST PERSISTENCE

docker volume create --name ghost_data

docker run -d --name ghost \
  -p 8080:8080 -p 8443:8443 \
  --env ALLOW_EMPTY_PASSWORD=yes \
  --env GHOST_DATABASE_USER=bn_ghost \
  --env GHOST_DATABASE_PASSWORD=bitnami \
  --env GHOST_DATABASE_NAME=bitnami_ghost \
  --env GHOST_USERNAME=aleksandra \
  --env GHOST_PASSWORD=goodToBeAlive123 \
  --env GHOST_EMAIL=aleksandra@yopmail.com \
  --network ghost-network \
  --volume ghost_data:/bitnami/ghost \
  bitnami/ghost:latest

### STEP 4 - START THE APPLICATION

docker-compose up -d
