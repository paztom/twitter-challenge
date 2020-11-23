Spring Boot Application with embedded tomcat.
Start application:
1. Go to project directory via command line 

2. Run command:
	mvn spring-boot:run
	 
	or
	
	build project:
	"mvn clean package" and then "java -jar target\twitter-challenge-0.0.1-SNAPSHOT.jar"

application port: 8088

API documentation:
http://localhost:8088/swagger-ui.html#/users-controller (or src/main/resources/twitterchallenge.yaml)

tomasz.pazera@gmail.com