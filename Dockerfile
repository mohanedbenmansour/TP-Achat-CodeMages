FROM maven:3.8.2-jdk-8
RUN apt-get install curl
RUN curl -u admin:adminadmin -o achat.jar "http://192.168.1.16:8081/repository/jenkins-repo/tn/esprit/rh/achat/1.0/achat-1.0.jar" -L
ENTRYPOINT ["java","-jar","/achat-1.0.jar"]
EXPOSE 8089
