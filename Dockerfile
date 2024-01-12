FROM openjdk:17
ADD target/sd-book-mongo.jar  app.jar
ENTRYPOINT [ "java", "-jar", "app.jar" ]
