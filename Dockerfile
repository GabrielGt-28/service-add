FROM openjdk:17-jdk-alpine
ADD service-add.jar service-add.jar
EXPOSE 8090
ENTRYPOINT [ "java", "-jar", "./service-add.jar" ]