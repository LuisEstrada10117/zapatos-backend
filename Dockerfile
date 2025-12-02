# Usa una imagen oficial con Java 17 y Gradle
FROM gradle:8-jdk17 AS build

# Copia los archivos del proyecto
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src

# Construye el proyecto, omitiendo tests
RUN gradle build -x test --no-daemon

# Crea la imagen final más ligera
FROM eclipse-temurin:17-jre

# Expone el puerto que usa Railway
EXPOSE $PORT

# Copia el JAR construido con el nombre exacto
COPY --from=build /home/gradle/src/build/libs/demo-0.0.1-SNAPSHOT.jar /app/app.jar

# Comando para ejecutar la app
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
