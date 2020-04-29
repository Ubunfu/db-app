FROM maven:3-openjdk-8-slim

EXPOSE 8080/tcp

WORKDIR /app/
COPY . /app/

RUN ["mvn", "package"]
ENTRYPOINT ["mvn", "spring-boot:run"]