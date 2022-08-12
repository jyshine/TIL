# Service Discovery
- Spring Cloud Netflix Eureka
- Eureka Service Discovery
- User Service -  Create New Project
- User Service - Rigister
- User Service - Load Balancer


![](Service%20Discovery/bear_sketch@2x.png)

- - - -
[Getting Started | Service Registration and Discovery](https://spring.io/guides/gs/service-registration-and-discovery/)

Service Discovery :
You will set up a  [Netflix Eureka service registry](https://github.com/spring-cloud/spring-cloud-netflix)  and then build a client that both registers itself with the registry and uses it to resolve its own host. A service registry is useful because it enables client-side load-balancing and decouples service providers from consumers without the need for DNS.


[Spring Cloud](https://spring.io/projects/spring-cloud)

- - - -
1.create new project
2.add dependency
	-Spring Cloud Discovery (Eureka Serve)
3.create application.yml  app setting file

4.add Annotation @EnableEurekaServer
```

# server port
server:
  port: 8761

# spring application name
spring:
  application:
    name: discoveryservice

# eureka client settings
eureka:
  client:
    register-with-eureka: false
    fetch-registry: false





```
- - - -
1.create new discoveryservice client  (service instance) project
2.add dependency
	-Eureka Discovery Client
	-Lombok
	-Spring Boot DevTools
	-Spring Web
3.ass annotation @EnableDicoverClient
4.create application.yml 
```
	server:
  port: 9001

spring:
  application:
    name: user-service

eureka:
  client:
    register-with-eureka: true
#    Eureka 서버로부터 인스턴스들의 정보를 주기적으로 가져올 것인지를 설정하는 속성.
#    true 로 설정하면, 갱신된 정보를 받겠다는 설정입니다.
    fetch-registry: true
    service-url:
      defaultZone: http://127.0.0.1:8761/eureka



```
		
5.RUN discoverservice And user-service
6.Check your Eureka Dashboard  
 	Eureka server url: http://localhost:8761
 	Eureka client url: http://localhost:9001
7.Add Run/Devug Configurations and Run application
	VM options : 	`-Dserver.port=9002 `

![](Service%20Discovery/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202022-08-11%20%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE%204.59.49.png)

8.Run command
```
Running by Gradle:
	•	Run in default port(8080): ./gradlew bootRun
	•	Run in provided port(8888): ./gradlew bootRun --args='--server.port=8888'
	•	If we have any variable in the application.properties file named PORT, run this: PORT=8888 ./gradlew bootRun
	•./gradlew clean build

Running by Maven:
	•	Run in default port(8080): mvnw spring-boot:run
	•	Run in provided port(8888): mvnw spring-boot:run -Dspring-boot.run.jvmArguments='-Dserver.port=8085'
	•	Run in provided port(8888): mvn spring-boot:run -Dspring-boot.run.arguments='--server.port=8085'
	•	Run in provided port(8888) with other custom property: mvn spring-boot:run -Dspring-boot.run.arguments="--server.port=8899 --your.custom.property=custom"
	•	If we have any variable in the application.properties file named PORT, run this: SERVER_PORT=9093 mvn spring-boot:run


Using java -jar:
	•	Create the .jar file:
	•	For Gradle: ./gradlew clean build. We will find the jar file inside: build/libs/ folder.
	•	For Maven: mvn clean install. We will find the jar file inside:target folder.
	•	Run in default port(8080): java -jar myApplication. jar
	•	Run in provided port(8888): java -jar myApplication.jar --port=8888
	•	Run in provided port(8888): java -jar -Dserver.port=8888  myApplication.jar
	•	Run in provided port(8888) having variable SERVER_PORT in application.properties file: SERVER_PORT=8888 java -jar target/myApplication.jar

```

- - - -
Using Random Port
application.yml 
```
server: 
	port:0 //Random port

eureka: 
	instance:
  instance-id: ${spring.cloud.client.hostname}:${spring.application.intance_id:${random.value}}


```


- - - -




#SpringCloud