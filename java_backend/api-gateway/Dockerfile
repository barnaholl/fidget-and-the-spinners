#
# Build stage
#
FROM maven:3.6.3-jdk-14 AS MAVEN_BUILD
COPY ./ ./
RUN mvn clean package -Dmaven.test.skip=true
CMD ["java", "-jar", "/target/api-gateway-0.0.1-SNAPSHOT.jar"]

##
## Package stage
##
FROM openjdk:14-alpine
COPY --from=MAVEN_BUILD /target/api-gateway-0.0.1-SNAPSHOT.jar /api-gateway.jar
CMD ["java", "-jar", "api-gateway.jar"]