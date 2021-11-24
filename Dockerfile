FROM openjdk:8
ADD target/csv-to-db-2.0 csv-to-db.jar
EXPOSE 8085
ENTRYPOINT ["java","-jar","csv-to-db.jar"]