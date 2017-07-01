FROM frolvlad/alpine-oraclejdk8
VOLUME /tmp
ADD  fbn-eureka-master-0.0.1-SNAPSHOT.jar fbn-eureka-master.jar 
EXPOSE 9002
ENTRYPOINT ["java","-jar","-Dserver.port=9002", "-Dspring.application.name=fbn-eureka-server1","fbn-eureka-master.jar"]
