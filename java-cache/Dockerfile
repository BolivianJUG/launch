FROM amazoncorretto

WORKDIR /usr/app

COPY build/libs/jmicros-all-1.0-SNAPSHOT.jar /usr/app/

ENTRYPOINT ["java", "-cp", "jmicros-all-1.0-SNAPSHOT.jar", "com.jmicros.EmbeddedRESTServer"]