FROM openjdk:11-jdk-alpine
COPY target/apisayhello-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
