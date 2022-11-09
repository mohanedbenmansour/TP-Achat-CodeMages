FROM adoptopenjdk/openjdk11:jre-11.0.6_10-alpine
ADD target/tpAchatProject-1.0.jar achat.jar
EXPOSE 8089
CMD ["java", "-jar", "/achat.jar"]
