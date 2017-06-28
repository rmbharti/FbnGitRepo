FROM frolvlad/alpine-oraclejdk8
VOLUME /tmp
ADD  fbn-config-server-0.0.1-SNAPSHOT.jar fbn-config-server.jar 
EXPOSE 9001
ENTRYPOINT ["java","-jar","-Dserver.port=9001", "-Dspring.application.name=fbn-config-server2","fbn-config-server.jar"]





