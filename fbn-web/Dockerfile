
FROM frolvlad/alpine-oraclejdk8
VOLUME /tmp
ADD  /target/fbn-web-0.0.1-SNAPSHOT.jar fbn-web.jar 
EXPOSE 8090
ENTRYPOINT ["java","-jar","/fbn-web.jar"]

