FROM registry.access.redhat.com/ubi8/ubi-minimal:8.5

LABEL MAINTAINER="Javeed Ghani"

LABEL BASE_IMAGE="registry.access.redhat.com/ubi8/ubi-minimal:8.5"
LABEL JAVA_VERSION="11"
LABEL GIT_HUB="https://github.com/gmdjaveed/hello-world-java-docker"

# Note: Environment variables defined using the ENV instruction always override an ARG instruction of the same name
# Default APP_NAME to HELLO if it is not passed!
ARG APP_NAME
ENV APP_NAME ${APP_NAME:-"HELLO"}
# Example of Docker Image build by passing "APP_NAME" arg :
#   $ docker build -t --build-arg APP_NAME=FOO gmdjaveed/jg-hello-world-java-docker:1.0 .

# Example of passing/overriding "APP_NAME" environment value:
#   $ docker run -ti -e APP_NAME=MAGIC -p:8080:8080 gmdjaveed/jg-hello-world-java-docker

RUN echo "APP_NAME is $APP_NAME"


RUN microdnf install --nodocs java-11-openjdk-headless && microdnf clean all

WORKDIR /work/
COPY target/*.jar /work/application.jar

EXPOSE 8080
CMD ["java", "-jar", "application.jar"]