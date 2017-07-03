
FROM frolvlad/alpine-oraclejdk8
VOLUME /tmp
ADD  target/fbn-search-0.0.1-SNAPSHOT.jar fbn-search.jar 
EXPOSE 8090
ENTRYPOINT ["java","-jar","/fbn-search.jar"]

