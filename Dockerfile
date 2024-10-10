FROM maven:3.8.8 AS dependencies
WORKDIR /opt/app
COPY pom.xml .
RUN mvn -B -e org.apache.maven.plugins:maven-dependency-plugin:3.1.2:go-offline -DexcludeArtifactIds=domain

FROM alpine:latest AS builder
RUN apk add --no-cache maven libx11 libxxf86vm mesa-gl
WORKDIR /opt/app
COPY --from=dependencies /root/.m2 /root/.m2
COPY --from=dependencies /opt/app/ /opt/app
COPY src/ /opt/app/src

ENTRYPOINT ["mvn", "javafx:run"]

