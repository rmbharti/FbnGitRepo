FROM frolvlad/alpine-oraclejdk8
VOLUME /tmp
ADD  fbn-config-server-0.0.1-SNAPSHOT.jar fbn-config-server.jar 
EXPOSE 9000
ENTRYPOINT ["java","-jar","-Dserver.port=9000", "-Dspring.application.name=fbn-config-server1","fbn-config-server.jar"]





