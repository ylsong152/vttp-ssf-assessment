FROM openjdk:21-bookworm AS builder

WORKDIR /src

COPY src src
COPY .mvn .mvn
COPY mvnw .
COPY mvnw.cmd .
COPY pom.xml .

# compile the Java application
RUN mvn package -Dmvn.test.skip=true

FROM openjdk:21-bookworm 

WORKDIR /app

# copy and rename to app.jar
COPY --from=builder /src/target/eventmanagement-0.0.1-SNAPSHOT.jar app.jar

ENV PORT=8080
EXPOSE $PORT

ENTRYPOINT SERVER_PORT=${PORT} java -jar ./app.jar