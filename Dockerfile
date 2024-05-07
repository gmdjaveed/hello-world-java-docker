FROM registry.access.redhat.com/ubi8/ubi-minimal:8.5

LABEL MAINTAINER="Javeed Ghani"

LABEL BASE_IMAGE="registry.access.redhat.com/ubi8/ubi-minimal:8.5"
LABEL JAVA_VERSION="11"
LABEL GIT_HUB="https://github.com/gmdjaveed/hello-world-java-docker"

RUN microdnf install --nodocs java-11-openjdk-headless && microdnf clean all

WORKDIR /work/
COPY target/*.jar /work/application.jar

EXPOSE 8080
CMD ["java", "-jar", "application.jar"]