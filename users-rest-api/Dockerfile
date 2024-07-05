FROM maven:3.9.8-eclipse-temurin-22 as builder
WORKDIR /opt/app
COPY pom.xml .
COPY src/ ./src
RUN mvn clean package -DskipTests=true

FROM bellsoft/liberica-openjdk-alpine as prod
LABEL authors="antonkhomenko"
WORKDIR /opt/app
COPY --from=builder /opt/app/target/*.jar /opt/app/rest.jar

EXPOSE 8081

ENTRYPOINT ["java","-Dspring.profiles.active=standalone", "-jar","rest.jar"]