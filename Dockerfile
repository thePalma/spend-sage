#Use existing image as base
FROM eclipse-temurin:22-jre-alpine

RUN addgroup -S spring && adduser -S spring -G spring

USER spring:spring

VOLUME /data

ARG JAR_FILE=target/spend-sage-0.0.1-SNAPSHOT.jar

# Retrive needed files and dependencies
COPY ${JAR_FILE} app.jar

# Expose the port
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java","-jar","/app.jar"]