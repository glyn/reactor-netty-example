# Alpine Linux with OpenJDK JRE
FROM openjdk:8-jre-alpine
# copy example code and dependencies into image
COPY reactor-netty-example.jar /reactor-netty-example.jar
COPY dependencies /dependencies
# run application with this command line. Listen on port 8081 on all IPv4 addresses in the container.
CMD ["/usr/bin/java","-cp", "reactor-netty-example.jar:dependencies/*", "server.Server", "8081", "0.0.0.0"]
