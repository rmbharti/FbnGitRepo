
FROM frolvlad/alpine-oraclejdk8
VOLUME /tmp
ADD  /target/search-apigateway-0.0.1-SNAPSHOT.jar fbn-search-gateway.jar 
EXPOSE 8090
ENTRYPOINT ["java","-jar","/fbn-search-gateway.jar.jar"]

