java -jar -Dserver.port=8087 -Dspring.application.name=search-apigateway1 -Deureka.instance.hostname=localhost -Dserver.address=127.0.0.1 c:\users\admin\desktop\workspace4\fbn-search-apigateway\target\search-apigateway-0.0.1-SNAPSHOT.jar

java -jar -Dserver.port=8097 -Dspring.application.name=search-apigateway2 -Deureka.instance.hostname=localhost1 -Dserver.address=127.0.0.2 c:\users\admin\desktop\workspace4\fbn-search-apigateway\target\search-apigateway-0.0.1-SNAPSHOT.jar

java -jar -Dserver.port=8083 -Deureka.instance.hostname=localhost -Dserver.address=127.0.0.1  C:\Users\admin\Desktop\workspace4\fbn-search\target\fbn-search-0.0.1-SNAPSHOT.jar
