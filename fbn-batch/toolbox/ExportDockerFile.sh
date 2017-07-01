
# use following command to show all instance of container
docker ps -a

docker ps only show u non running instances

Using desktop since desktop is mounted as shared folder in VB

 docker export $CONTAINER_ID > \Desktop\AWS-Workspace\fbn-config-server\docker\fbn-config-server10.tar
cat image.tar > sudo docker import - image_flat.tar


Docker Pull
sudo docker pull : download a docker image from the docker registry
Docker Images (List Images)
sudo docker images : list all of the locally downloaded images
sudo docker images --digests=true : list all of the locally downloaded Docker images with their digests. This is needed for application publishing in BaseSpace.
Docker Run
sudo docker run –i –t repo_name command_to_run : run a docker image interactively with a certain command and jump into the running container.
Repo_name = [docker_username]/[docker_image_name]. Command_to_run = the command to be run in the interactive docker container, commonly we use the /bin/bash command.

Docker ps -a (List Containers)
sudo docker ps –a : list all of the local Docker containers (that were previously executed with a Run command)
Docker Commit (Save Changes Locally)
sudo docker commit container_id image_name : commit changes made to a local docker container to save any changes made locally.
The container_id can be found from the above sudo docker ps –a command. The image_name is the name of the local image where this change should be applied, this is the same format as the repo_name above.

Docker Push (Save Updated Image in Docker Registry)
sudo docker push repo_name : push all locally committed changes to the docker registry and update the docker image specified by the repo_name with the changes.
Repo_name = [docker_username]/[docker_image_name]

Docker Stop
sudo docker stop $(sudo docker ps –a -q) : stop all locally running docker containers
Docker rm (Remove/Delete Docker Containers or Images)
sudo docker rm $(sudo docker ps –a -q) : remove/delete all local docker containers
sudo docker rm $(sudo docker images -q) : remove all docker images from your local machine
