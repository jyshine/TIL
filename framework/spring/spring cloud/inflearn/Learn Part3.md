
# Configuration Service

[Spring Cloud Config](https://docs.spring.io/spring-cloud-config/docs/current/reference/html/)


**Spring Cloud Config Server 생성**

1) 프로젝트 생성 및 Dependency 추가
	spring-cloud-config-server
2) Spring Boot 실행 Class에 @EnableConfigServer 추가
3) application.yml 서버 설정 파일 생성

```
server:
  port: 8888

spring:
  application:
    name: config-service
  cloud:
    config:
      server:
        git:
          uri: https://github.com/jyshine/config-repo.git
			# username: [git username]
			# password: [git password]
```

4) 서버 실행 후 설정파일 확인
 http://localhost:8888/user-service/default
```
// 20220829143213
// http://localhost:8888/user-service/default

{
  "name": "user-service",
  "profiles": [
    "default"
  ],
  "label": null,
  "version": "9108f87b6b346bac7feb6d0526d01c2c7462c1f6",
  "state": null,
  "propertySources": [
    {
      "name": "https://github.com/jyshine/config-repo.git/user-service.yml",
      "source": {
        "token.expiration_time": 86400000,
        "token.secret": "TestForCreatingSpringCloudAuthenticationJWTToken"
      }
    }
  ]
}
```

---
**Spring Cloud Config Client 설정**
1) dependency 추가
	spring-cloud-starter-config
2) application.yml 설정 추가
	By default, if no application name is set, application will be used. To modify the name, the following property can be added to the application.properties
```
spring:
	application:
		name: user-service
	config:
		# import: optional:configserver:{서버 주소}
  		import: optional:configserver:http://127.0.0.1:8888
	# profiles 설정안하면 기존 application name 설정파일로 설정
	profiles:
		active: dev
```

---
**Spring의 설정파일 (application.yml or .properties) 변경 시 서버 반영하는 방법**

1.서버 재가동
2.Actuator refresh
	-Application 상태, 모니터링
	-Metric 수집을 위한 Http End point 제공
	1) dependency 추가
		spring-boot-starter-actuator
	2)  application.yml 설정 추가
```
# spring actuator
management:
  endpoints:
    web:
      exposure:
		  # include: 사용할 서비스 입력
        include: refresh, health, beans, env

```

	3) Client 서버 실행 및 Actuator 기동 확인
	http://192.168.0.46:51257/actuator/health
```
{
  "status": "UP"
}	
```
	4) Config Repository 설정 값 수정
	5) Actuator Refresh
		[Post Method] http://192.168.0.46:51257/actuator/refresh 
---
3.Spring cloud bus
	Actuator refresh 사용할 경우 변경 반영할 micro service 서버에 가서 직접 refresh 해줘야한다.
	 이러한 번거로움을 개선하기 위해 미들웨어 spring cloud bus를 추가하여 AMQP 로 처리한다.
	-분산 시스템의 노드를 경향 메시지 브로커와 연결
	-상태 및 구성에 대한 변경 사항을 연결된 노드에게 전달(broadacst)

Spring Cloud Config Server + Spring Cloud Bus
AMQP (Advanced Message Queuing Protocol) 이용하여 Push updates 이벤트를 MS 에 발생 시켜 Refresh 되도록 처리.

Erlang, RabbitMQ 사용
 kafka, pulsar, rabbitMQ 비교
  [Benchmarking Kafka vs. Pulsar vs. RabbitMQ: Which is Fastest?](https://www.confluent.io/blog/kafka-fastest-messaging-system/)

RabbitMQ 설치 방법
```
$ brew update
$ brew install rabbitmq
$ export PATH=$PATH:/usr/local/sbin

$ cd /opt/homebrew/sbin/
$ rabbitmq-server

# 127.0.0.1:15672
# username: guest
# password: guest
```

	1) AMQP, Actuator 의존성 추가
Config Server
```
// https://mvnrepository.com/artifact/org.springframework.cloud/spring-cloud-starter-bus-amqp
implementation 'org.springframework.cloud:spring-cloud-starter-bus-amqp:3.1.2'

// https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-actuator
implementation 'org.springframework.boot:spring-boot-starter-actuator:2.7.3'

```

User Microservice, Gateway Service
```
// https://mvnrepository.com/artifact/org.springframework.cloud/spring-cloud-starter-bus-amqp
implementation 'org.springframework.cloud:spring-cloud-starter-bus-amqp:3.1.2'
```

	2) Config Server, Users Microservice, Gateway Service application.yml 설정에 rabbitmq 설정
```
spring:
  application:
    name: config-service
#  profiles:
#    active: native

  rabbitmq:
    host: 127.0.0.1
    port: 5672
    username: guest
    password: guest

management:
  endpoints:
    web:
      exposure:
        include: health, busrefresh

```

	3) Test
		-Start RabbitMQ Server
		-Start Spring Cloud Config Service
		-Start Eureka Discovery Service
		-Start Spring Cloud Gateway Service
		-Start Users Microservice

----




