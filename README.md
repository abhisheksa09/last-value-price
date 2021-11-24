# Last value price service
Application using spring-boot to read a CSV to H2 database

Sample data csv file is included in src/main/resources. 

Steps to run this application using docker:

1> run <mvn install> to create the csv-to-db-2.0.jar
2> Build the docker image: 
   run the command: <docker build -t csvtodb -f ./Dockerfile .>
3> Run the docker container with the above image using the command: 
   <docker run csvtodb>

Swagger UI 
------------
Swagger UI with documentation of the available APIs will be avaialble at http://localhost:8080/swagger-ui.html

APIs and URLs
-------------
1> POST instrument data:
Using postman, choose a csv file at the following URL to upload csv file data to the H2 DB: http://localhost:8080/v1/instruments

2> GET instrument data by ID:
http://localhost:8080/v1/instruments/{id}

H2 database console
-------------------
This application is built using the H2 in memory database. Once the CSV file is uploaded, open h2 console which is available at localhost:8080/h2-console
Make sure JDBC URL is jdbc:h2:mem:testdb
username: admin
password: password
