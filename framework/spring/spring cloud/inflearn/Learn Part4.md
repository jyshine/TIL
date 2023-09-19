# API Gateway Service

Client Side 에서 Microservices End point 로 요청하는 구조는 End point 서비스의 수정이 발생하면 Client도 같이 수정해줘야한다. 

이러한 점을 개선하기 위해 Client 와 End point 사이에 단일 진입점을 가지고 있는 API Gateway를 구성한다.

- 인증 및 권한부여를 위한 작업을 단일 작업으로 할 수 있음
- 서비스 검색 통합
- 응답 캐싱
- 정책, 회로 차단기 및 QoS 다시 시도
- 속도 제한
- 부하분산
- 로깅, 추적, 상관관계
- 헤더, 쿼리 문자열 및 청구 변환
- IP 허용 목록에 추가

---
**Spring Cloud 에서 MAS 간 통신 (비동기 가능)**
1) RestTemplate
2) Feign Client

**Ribbon**
Client side Load Balancer
-서비스 이름으로 호출
-Health Check
단점 : 비동기 처리가 안됨

**Netflix Zuul**
							|----- First Service
client     <——>  Netflix Zuul      —|
							|----- Second Service
				    - Routing
				    - API gateway
				
---
**Create New Spring Cloud API gateway Project** 
   -Select depandency: Lombok, Eureka Discovery Client, Gateway
   -Create applicateion.yml
```
server:
  port: 8000

eureka:
  client:
    register-with-eureka: false
    fetch-registry: false
    service-url:
      defaultZone: http://localhost:8761/eureka

spring:
  application:
    name: springcloud-apigateway-service
  cloud:
    gateway:
      routes:
        - id: first-service
          uri: http://localhost:8081/
          predicates:
            - Path=/first-service/**
        - id: second-service
          uri: http://localhost:8081/
          predicates:
            - Path=/second-service/**


	
```

---
**Create New Service Instance 1,2**
	-Select dependency: Lombok, Spring Web, Eureka Discovery Client
	-Edit application.yml
```
server:
  #first service 8001
  #second service 8002
  port: 8001 

spring:
  application:
    name: my-first-serivce

eureka:
  client:
    fetch-registry: false
    register-with-eureka: false
		
```
	-Create Rest Controller

---
**Spring Cloud Gateway - Filter**


									|---  -> First Service
Client    <- ->  Spring Cloud gateway 	|
								  	|---  -> Second Service

			Gateway Handler Mapping
			Predicate (Java Code, Property)
				-Pre Filter -> Service
				-Post Fileter <- Service
			
			
1.application.yml 사용 방법
```
server:
  port: 8000

eureka:
  client:
    register-with-eureka: false
    fetch-registry: false
    service-url:
      defaultZone: http://localhost:8761/eureka

spring:
  application:
    name: springcloud-apigateway-service
  cloud:
    gateway:
      routes:
        - id: first-service
          uri: http://localhost:8001/
          predicates:
            - Path=/first-service/**
        - id: second-service
          uri: http://localhost:8002/
          predicates:
            - Path=/second-service/**


```

2.Javc Code 사용 방법
-기존 application.yml의 spring cloud 설정 주석
-Config 클래스 생성 및 @Configuration  RouteLocator 메모리 등록
1) Java Code
```
@Configuration
public class FilterConfig {
    @Bean
    public RouteLocator gatewayRouters(RouteLocatorBuilder builder){
        return builder.routes()
                .route(r -> r.path("/first-service/**")
                        .filters(f-> f
                                .addRequestHeader("first-request","first-request-header")
                                .addResponseHeader("first-request","first-response-header")
                        )
                        .uri("http://localhost:8001"))
                .route(r -> r.path("/second-service/**")
                        .filters(f-> f
                                .addRequestHeader("second-request","second-request-header")
                                .addResponseHeader("second-request","second-response-header")
                        )
                        .uri("http://localhost:8002"))
                .build();
    }

}

```

2) properties 사용
```
server:
  port: 8000

eureka:
  client:
    register-with-eureka: false
    fetch-registry: false
    service-url:
      defaultZone: http://localhost:8761/eureka

spring:
  application:
    name: springcloud-apigateway-service
  cloud:
    gateway:
      routes:
        - id: first-service
          uri: http://localhost:8001/
          predicates:
            - Path=/first-service/**
          filters:
            - AddRequestHeader=first-request, first-request-header2
            - AddResponseHeader=first-response, first-response-header2
        - id: second-service
          uri: http://localhost:8002/
          predicates:
            - Path=/second-service/**
          filters:
            - AddRequestHeader=second-request, second-request-header2
            - AddResponseHeader=second-response, second-response-header2



```


---
**Custom Filter**
Create CustomFilter Class 
-Extends AbstractGatewayFilterFactory 
-Create inner Class Config 생성
-Override apply method 
-Add CustomFilter in application.yml
 spring.cloud.gateway.routes.filters
---
**Global Filter**
Create Global Filter Class 
-Extends AbstractGatewayFilterFactory
-Create inner Class Config
-Override apply method
-Add CustomFilter in application.yml
spring.cloud.gateway.default-filters
---
**Logging Filter**
Create Global Filter Class 
-Extends AbstractGatewayFilterFactory
-Create inner Class Config
-Override apply method
-Add CustomFilter in application.yml
spring.cloud.gateway.routes.filters
---
**Load Balancer**
[image:7370110E-182B-408E-BA44-2F11C7808FFF-250-00000002064CFA60/bear_sketch@2x.png]
-Add Eureka Client  Library
Spring Cloud Gatewau, First service, Second Service 
-Edit application.yml
```
eureka:
  client:
    register-with-eureka: true
    fetch-registry: true
    service-url:
      defaultZone: http://localhost:8761/eureka

```

-Edit Spring Cloud Gateway
  기존 uri 주소 경로를 서비스 이름으로 변경
```
  cloud:
    gateway:
      default-filters:
        - name: GlobalFilter
          args:
            baseMessage: Spring Cloud Gateway Global Filter
            preLogger: true
            postLogger: true
      routes:
        - id: first-service
          uri: lb://MY-FIRST-SERIVCE
          predicates:
            - Path=/first-service/**
          filters:
            - CustomFilter

```

-Check Eureka Service Registration


0 랜덤 포트로 실행할 경우 instance id 를 입력해줘야한다.
```
eureka:
  client:
    register-with-eureka: true
    fetch-registry: true
    service-url:
      defaultZone: http://localhost:8761/eureka
  instance:
    instance-id: ${spring.application.name}:${spring.application.instance_id:${random.value}}

```

service 에서 실행되는 port 번호확인
1) 환경설정 값 불러와서 확인하는 방법
```
Environment environment;

@Autowired
public FirstServiceController(Environment environment) {
    this.environment = environment;
}
```
2) HttpServletRequest 을 파라미터로 받아서 확인하는 방법
```
@GetMapping("/check")
public String check(HttpServletRequest httpServletRequest){
    log.info("Server port={}", httpServletRequest.getServerPort());
    return String.format("check first-service custom filter on Port : %s",
            environment.getProperty("local.server.port"));
}

```

 





#SpringCloud