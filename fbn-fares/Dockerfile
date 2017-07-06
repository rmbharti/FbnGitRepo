FROM frolvlad/alpine-oraclejdk8
VOLUME /tmp
ADD  target/fbn-fares-service-0.0.1-SNAPSHOT.jar fbn-fares-service.jar 
EXPOSE 9004
ENTRYPOINT ["java","-jar","-Dserver.port=9004", "-Dspring.application.name=fbn-fare-service1","fbn-fares-service.jar"]
