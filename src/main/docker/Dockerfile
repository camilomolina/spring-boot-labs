FROM frolvlad/alpine-oraclejdk8:slim
#FROM java:8
MAINTAINER Camilo Molina <camilo.molina.orth@gmail.com>
#VOLUME /tmp
ADD users-0.0.1.jar app.jar
RUN sh -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-Xdebug", "-Xrunjdwp:server=y,transport=dt_socket,address=8701,suspend=n", "-jar","/app.jar"]
