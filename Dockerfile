# syntax=docker/dockerfile:1

# ---------- Build stage ----------
FROM eclipse-temurin:25-jdk AS build
WORKDIR /workspace

# Cache Maven dependencies first
COPY .mvn/ .mvn/
COPY mvnw pom.xml ./
RUN --mount=type=cache,target=/root/.m2 ./mvnw -B -ntp dependency:go-offline

COPY src/ src/
RUN --mount=type=cache,target=/root/.m2 ./mvnw -B -ntp clean package -DskipTests \
    && cp target/*.jar app.jar \
    && java -Djarmode=tools -jar app.jar extract --layers --launcher --destination extracted

# ---------- Runtime stage ----------
FROM eclipse-temurin:25-jre
WORKDIR /app

# curl is used by the docker-compose healthcheck
RUN apt-get update \
    && apt-get install -y --no-install-recommends curl \
    && rm -rf /var/lib/apt/lists/* \
    && groupadd --system spring && useradd --system --gid spring spring

# Copy Spring Boot layers (least to most frequently changing)
COPY --from=build /workspace/extracted/dependencies/ ./
COPY --from=build /workspace/extracted/spring-boot-loader/ ./
COPY --from=build /workspace/extracted/snapshot-dependencies/ ./
COPY --from=build /workspace/extracted/application/ ./

USER spring:spring
EXPOSE 8080

ENV JAVA_TOOL_OPTIONS="-XX:MaxRAMPercentage=75.0"
ENTRYPOINT ["java", "org.springframework.boot.loader.launch.JarLauncher"]
