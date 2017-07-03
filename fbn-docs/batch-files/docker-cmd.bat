# command that builds the search
docker build -t search:1.0 .

#command that runs the image
docker run--net 127.0.0.1 -p 8089:8089  fbn-web:1.0
 
# Command that shows list of all images
docker images

# Command that shows machine IP Address
docker-machine ip default

# Command that pulls rabbit mq from doc hug 
docker run -d --hostname my-rabbit --name some-rabbit rabbitmq:3

# Docker command to create private registry rather than using public registry
docker run -d -p 5000:5000 --restart=always --name registry registry:2

# Command that tags the docker file to registry
docker tag search:1.0 localhost:5000/search:1.0

# Push images to registry via following command
docker push localhost:5000/search:1.0

# Pull image back from registry as follows:
docker pull localhost:5000/search:1.0

# Command that pushes the images to dockers hub or public repository
docker tag search:1 search:1.0

docker push search:1.0