FROM adoptopenjdk/openjdk8

ENV APP_JAR_NAME="DockerApp-0.0.1-SNAPSHOT.jar"
ENV JAVA_OPTS="-Xms512m -Xmx512m"

COPY target/$APP_JAR_NAME $APP_JAR_NAME

EXPOSE 8080

ENTRYPOINT ["java","-jar", "DockerApp-0.0.1-SNAPSHOT.jar"]