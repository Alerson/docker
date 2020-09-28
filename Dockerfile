FROM maven:3.3-jdk-8 as builder
COPY . /usr/src/crud
WORKDIR /usr/src/crud

RUN mvn clean install -f /usr/src/crud -Dmaven.test.skip

EXPOSE 8080:8080
ENTRYPOINT ["java","-jar","/usr/src/crud/target/agenda-0.0.1-SNAPSHOT.jar"]

