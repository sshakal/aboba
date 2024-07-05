FROM maven:3.9.8-eclipse-temurin-22 as builder
WORKDIR /opt/app
COPY pom.xml .
COPY src/ ./src
RUN mvn clean package -DskipTests=true

FROM bellsoft/liberica-openjdk-alpine as prod
LABEL authors="antonkhomenko"
WORKDIR /opt/app
COPY --from=builder /opt/app/target/*.jar /opt/app/manager.jar

EXPOSE 8080

ENTRYPOINT ["java","-Dspring.profiles.active=standalone", "-jar","manager.jar"]