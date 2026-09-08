FROM eclipse-temurin:25-jdk AS builder

WORKDIR /build

COPY . .

RUN ./mvnw clean package -DskipTests


FROM eclipse-temurin:25-jre

WORKDIR /app

COPY --from=builder /build/target/spring-boot-demo-0.0.1-SNAPSHOT.jar app.jar

COPY ./src/main/resources/application-prod.properties /app/config/application-prod.properties

COPY ./.env /app/.env

ENV SPRING_CONFIG_LOCATION=/app/config/application-prod.properties

ENV SPRING_PROFILES_ACTIVE=prod

ENTRYPOINT ["java", "-jar", "app.jar"]
