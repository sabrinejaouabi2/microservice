FROM openjdk:17

EXPOSE 8082

ADD target/categories-0.0.1-SNAPSHOT.jar  Miniprojet-docker.jar

ENTRYPOINT ["java" , "-jar" , "Miniprojet-docker.jar"]