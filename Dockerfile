FROM maven:3-eclipse-temurin-21 AS builder

ARG APP_DIR=/app
WORKDIR ${APP_DIR}

COPY mvnw .
COPY pom.xml .
COPY .mvn .mvn
COPY src src

RUN mvn package -Dmaven.test.skip=true

FROM maven:3-eclipse-temurin-21 

WORKDIR /app

# copy and rename to app.jar
COPY --from=builder /src/target/eventmanagement-0.0.1-SNAPSHOT.jar app.jar

ENV PORT=8080
EXPOSE $PORT

ENTRYPOINT SERVER_PORT=${PORT} java -jar target/eventmanagement-0.0.1-SNAPSHOT.jar