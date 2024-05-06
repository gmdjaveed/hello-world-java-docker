# A Containerized Hello World Java deployment with Docker 

a very simple rest-api-hello-world java application with Spring Boot and Maven, containerized with dockerfile, ready to build and deployed with a very simple way.

## JG Added - Start ############################

### Original github Source:
``` remote.origin.url=https://github.com/edwin/hello-world-java-docker.git ```

### Reference:
``` https://edwin.baculsoft.com/2020/07/building-containerized-images-on-openshift-4-and-push-the-result-to-third-party-image-registry/ ```

### How to Build the application JAR file
```
 - First build the application in Intellij/any tool using maven "package" lifecycle.
 - This will create a jar as below in the src (target/) directory:
 :::
 [INFO] --- maven-jar-plugin:3.1.2:jar (default-jar) @ hello-world-docker ---
 [INFO] Building jar: C:\AppsData\IdeaProjectsIntelliJ\hello-world-java-docker\target\hello-world-docker-1.0-SNAPSHOT.jar
 ::
```

### Note: 
``` Since minor modification is made to the code and tested lets add to our own github repo for future reference!```

### MyGitHubRepo:
``` https://hub.docker.com/repositories/gmdjaveed ```

## JG Added - End ############################


## How to Build
```
docker build -t hello-world-java-docker .
```  

## How to Run

```
## pom.xml updated as <artifactId>hello-world-java-docker</artifactId> to create jar with this name!
docker run -ti -p:8080 hello-world-java-docker
```
## How to Test

```
a) Tested to be working inside the container (exec from docker-desktop)

sh-4.4# curl http://localhost:8080/hello
{"success":true,"new-message":"adding a new msg","hello":"hello world"}sh-4.4

b) Tested from HOST localhost:8080 once we exposed the port with -p8080:8080
{"success":true,"new-message":"adding a new msg","hello":"hello world"}
```

## Blog Post
```
https://edwin.baculsoft.com/2020/07/building-containerized-images-on-openshift-4-and-push-the-result-to-third-party-image-registry/
```
