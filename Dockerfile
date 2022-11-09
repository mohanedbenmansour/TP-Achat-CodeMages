FROM openjdk:8-jdk-alpine
RUN yum install curl
RUN curl -u admin:adminadmin -o achat.jar "http://192.168.1.38:8081/repository/maven-releases/com/esprit/examen/tpAchatProject/1.0/tpAchatProject-1.0.jar" -L
ENTRYPOINT ["java","-jar","/achat.jar"]
EXPOSE 8089
