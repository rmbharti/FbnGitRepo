FROM frolvlad/alpine-oraclejdk8
VOLUME /tmp
ADD  fbn-eureka-master-0.0.1-SNAPSHOT.jar fbn-eureka-master.jar 
EXPOSE 9003
ENTRYPOINT ["java","-jar","-Dserver.port=9003", "-Dspring.application.name=fbn-eureka-server2","fbn-eureka-master.jar"]
