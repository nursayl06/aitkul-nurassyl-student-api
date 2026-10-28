# ---------- Stage 1: build the JAR with Gradle ----------
FROM eclipse-temurin:21-jdk AS build
WORKDIR /app

# Gradle wrapper and build files first (better layer caching)
COPY gradlew settings.gradle build.gradle ./
COPY gradle ./gradle
RUN chmod +x gradlew && ./gradlew dependencies --no-daemon > /dev/null

# Source code, then build the JAR (tests run in Jenkins Test stage)
COPY src ./src
RUN ./gradlew bootJar --no-daemon -x test

# ---------- Stage 2: small runtime image ----------
FROM eclipse-temurin:21-jre
LABEL maintainer="Aitkul Nurassyl" student.id="37375" group="IT2-2307"
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
ENV APP_VERSION=1.0.0
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
