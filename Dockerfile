FROM openjdk:11-jre-slim
ADD target/weather-info-service.jar weather-info-service.jar
EXPOSE 8085
ENTRYPOINT ["java","-jar","weather-info-service.jar"]
