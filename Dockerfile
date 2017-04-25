FROM openjdk:8-jre-alpine
VOLUME /tmp
ADD app.jar /
RUN sh -c 'touch /app.jar'
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]
EXPOSE 8080
