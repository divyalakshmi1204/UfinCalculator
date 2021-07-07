FROM openjdk:latest 

ADD /target/Ufinity-0.0.1-SNAPSHOT.jar Ufinity-Docker.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "Ufinity-Docker.jar" ]