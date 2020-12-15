#
# Build stage
#
FROM maven:3.6.3-jdk-14 AS MAVEN_BUILD
COPY ./ ./
RUN mvn clean package -Dmaven.test.skip=true
CMD ["java", "-jar", "/target/user-handler-service-0.0.1-SNAPSHOT.jar"]

##
## Package stage
##
FROM openjdk:14-alpine
COPY --from=MAVEN_BUILD /target/user-handler-service-0.0.1-SNAPSHOT.jar /user-handler-service.jar
CMD ["java", "-jar", "user-handler-service.jar"]