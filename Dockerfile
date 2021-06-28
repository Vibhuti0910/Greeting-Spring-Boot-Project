FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENV TOPIC_NAME=${TOPIC_NAME}
ENV SUBSCRIPTION_NAME=${SUBSCRIPTION_NAME}
ENV CONNECTION_STRING=${CONNECTION_STRING}
ENTRYPOINT ["java","-jar","/app.jar"]