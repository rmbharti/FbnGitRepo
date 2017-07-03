FROM frolvlad/alpine-oraclejdk8
VOLUME /tmp
ADD  ../fare-apigateway-0.0.1-SNAPSHOT.jar fare-apigateway.jar 

EXPOSE 9007

ENTRYPOINT ["java","-jar","-Dserver.port=9007", "-Dspring.application.name=fbn-fare-apigateway","fare-apigateway.jar"]

