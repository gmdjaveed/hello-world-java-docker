# A Containerized Hello World Java deployment with Docker

A very simple rest-api-hello-world java application with Spring Boot and Maven, containerized with dockerfile, ready to build and deployed with simple steps.\
Also demonstrate passing of environment variables!

## Pre-requisite:
```
- Need Docker-Desktop Installation
- Java application build tool like Intelij (If you want to modify the application & test locally)
```


## Git Hub Repo (Application):
``` 
git clone https://hub.docker.com/repositories/gmdjaveed 
```

## Docker Hub Repo (Docker Image of the Application):
```
docker pull gmdjaveed/jg-hello-world-java-docker
```

## How to Run Docker Image
```
docker run -ti -p 8080:8080 gmdjaveed/jg-hello-world-java-docker
(OR) override APP_NAME env variable
docker run -ti -e APP_NAME=MAGIC -p:8080:8080 gmdjaveed/jg-hello-world-java-docker
```

## How to Test the Application
```
http://localhost:8080/hello
```

## How to :
(a) Build Application locally \
(b) Build Docker Image locally \
(c) Run the docker container and \
(d) Test the Application

```
 - (a) Buiild Application locally: 
  
    -- Build the application in Intellij/any tool using maven "package" lifecycle.
  
    -- This will create a jar as below in the build (target/) directory:
        :::
        [INFO] --- maven-jar-plugin:3.1.2:jar (default-jar) @ hello-world-docker ---
        [INFO] Building jar: C:\AppsData\IdeaProjectsIntelliJ\hello-world-java-docker\target\hello-world-docker-1.0-SNAPSHOT.jar
        ::

 - (b) Build Docker Image locally:
   
   # To create Docker image (with default Environment variable APP_NAME=HELLO)
     docker build -t gmdjaveed/jg-hello-world-java-docker .
     (OR)
   # To pass Environment variable APP_NAME with the docker image
     docker build --build-arg APP_NAME=FOO -t gmdjaveed/jg-hello-world-java-docker .

 
 - (c) Run the docker container:
     docker run -ti -p:8080:8080 gmdjaveed/jg-hello-world-java-docker
     (OR)
   # To pass/override Environment variable "APP_NAME"
     docker run -ti -e APP_NAME=MAGIC -p:8080:8080 gmdjaveed/jg-hello-world-java-docker   

 - (d) Test the Application:
   http://localhost:8080/hello
   
 - (e) Sample Application output from the browser:  
    {
      "localHostName" : "a2872b9b0bc3",
      "success" : "true",
      "APP_NAME" : "HELLO",
      "localHostAddress" : "172.17.0.3",
      "hello" : "world",
      "remoteHostAddress" : "127.0.0.1",
      "remoteHostName" : "localhost"
    }
```