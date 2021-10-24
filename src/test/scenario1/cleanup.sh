docker-compose stop ghost
docker network rm ghost-network
docker rm -f $(docker ps -a -q)
docker-compose down --remove-orphans
docker volume rm $(docker volume ls -q)