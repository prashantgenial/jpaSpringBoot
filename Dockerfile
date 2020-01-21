FROM openjdk:8-jdk-alpine
VOLUME /tmp
WORKDIR /home/prashant_gcp_india/jpaSpringBoot
COPY ./target/jpaOneToOne-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
EXPOSE 8080