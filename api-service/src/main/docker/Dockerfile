FROM openjdk:8
VOLUME /tmp
ADD api-service.jar app.jar
RUN sh -c 'touch /app.jar'
ENV JAVA_OPTS=""
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Duser.timezone=GMT+08","-jar","/app.jar"]