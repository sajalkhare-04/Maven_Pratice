#BASE IMAGE

FrOM openjdk:17-jdk-slim

#WORKING DIRECTORY

WORKDIR /app

#COPY THE CODE

COPY /target/pratice_maven-1.0-SNAPSHOT.jar   /app/pratice_maven.jar

EXPOSE 8080

CMD ["java", "-jar", "/app/pratice_maven.jar"]
