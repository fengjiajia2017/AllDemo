FROM openjdk:8-alpine
EXPOSE 8080
ADD /target/demo1-helloworld-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT [ "java", "-jar", "/app.jar" ]