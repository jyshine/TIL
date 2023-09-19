# E-commerce 애플리케이션


[image:6953D075-E4A0-4EF5-AF87-5E9094D4DB2C-633-0000005C3B1F8F53/스크린샷 2022-08-16 오후 6.24.32.png]

---

Git Repository: 마이크로서비스 소스 관리 및 프로파일 관리
Config Server: Git 저장소에 등록된 프로파일 정보 및 설정 정보
Eureka Server: 마이크로서비스 등록 및 검색
API-Gateway server: 마이크로서비스 부하 분산 및 서비스 라우팅
Microservices: 회원MS, 주문MS, 상품MS
Queuing System: 마이크로 서비스 간 메시지 발행 및 구독

---
**1.User Microservice**
-Dependencies 추가 (DevTool, Lombok, Web, H2, Eureka Discovery Client, JPA, Modelmapper, jakarta.validation
-Application Class @EnableDiscoveryClient 
-application.yml
```
server:
  port: 0

spring:
  application:
    name: user-service
  # H2 설정
  h2:
    console:
      enabled: true
      settings:
        web-allow-others: true
      path: /h2-console
  datasource:
    driver-class-name: org.h2.Driver
    url: jdbc:h2:mem:test

eureka:
  instance:
    instance-id: ${spring.application.name}:${spring.application.intance_id:${random.value}}
  client:
    register-with-eureka: true
#    Eureka 서버로부터 인스턴스들의 정보를 주기적으로 가져올 것인지를 설정하는 속성.
#    true 로 설정하면, 갱신된 정보를 받겠다는 설정입니다.
    fetch-registry: true
    service-url:
      defaultZone: http://127.0.0.1:8761/eureka

# 임의로 입력하는 값
gretting:
  message: Welcome to the User Service







```

-RestController 생성 (상태 체크, welcome)
-Welcome message
 (Environment Class 사용, @Value 사용)
-DB Test H2 1.3버전 때 자동으로 DB 생성해줌.

-API 개발
  회원가입 (users)
 RequestUser -> UserDTO -> UserEntity
[Client]			[Server]			[DB]
[Front]			[Business Logic] 	[DB]
---
**Spring Security 연동**
[Spring Security without the WebSecurityConfigurerAdapter](https://spring.io/blog/2022/02/21/spring-security-without-the-websecurityconfigureradapter)
[spring-boot/SpringBootWebSecurityConfiguration.java at ac59b5781f30d98b8873fd0dc0010a5dbb9ccf5b · spring-projects/spring-boot · GitHub](https://github.com/spring-projects/spring-boot/blob/ac59b5781f30d98b8873fd0dc0010a5dbb9ccf5b/spring-boot-project/spring-boot-autoconfigure/src/main/java/org/springframework/boot/autoconfigure/security/servlet/SpringBootWebSecurityConfiguration.java#L99-L105)
-Authentication + Authorization (인증 + 권한)
-Add Dependency (spring security jar) in Application 
-Configuring HttpSecurity
```
@Configuration
public class WebSecurity {

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer(){
        return (web -> {
            web.ignoring().antMatchers("/users/**","/h2-console/**");

        });
    }
}

```

-Password encode를 위한 BCryptPasswordEncoder 빈 정의
  main 에서 BCryptPasswordEncoder 객체 생성 후 서비스에서 주입 받아 사용.
```
@Bean
public BCryptPasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
}

```

-Root Request Mapping 정보 변경
-API Gateway Service 변경 User service route 추가
	uri pattern 설정

-ResponseUser, ResponseOder Class 생성, 
 UserService getUserByUserId,  getUserByAll() 생성


**2.Catalogs and Orders Microservice**

Catalog Service 생성
-프로젝트 생성 및 Dependencise 추가 
-application.yml 파일 추가
-data.sql 생성
-CatalogEntity.java, CatalogRepository.java
-CatalogDTO.java, ResponseCatalog.java
-CatalogService.java, CatalogServiceImpl.java
-CatalogController.java 
-API-gateway에 등록

Order Service 생성
-프로젝트 생성 및 Dependencise 추가 
-application.yml 파일 추가
-OrderEntity.java, OrderRepository.java
-OrderDTO.java,, ResponseOrder.java,
-OrderService.java,, OrderServiceImpl.java
-OrderController.java
-API-gateway 등록


Test
User등록
User조회
Catalog 조회
Order 등록
Order 조회

---
**3.User Login 관련 작업**
[UsernamePasswordAuthenticationToken (Spring Security 4.0.4.RELEASE API)](https://docs.spring.io/spring-security/site/docs/4.0.x/apidocs/org/springframework/security/authentication/UsernamePasswordAuthenticationToken.html)

[SpringMicroServiceTest/SecurityConfig.java at main · Eco-Min/SpringMicroServiceTest · GitHub](https://github.com/Eco-Min/SpringMicroServiceTest/blob/main/user-service/src/main/java/com/example/userservice/security/SecurityConfig.java)

User Service JWT 토큰 방식 로그인
-RequestLogin.java
-AuthenticationFilter.java
Spring Security를 이용한 로그인 요청 발생 시 작업 처리 필터
-WebSecurity.java
-UserDetailService 생성 및 상속 (로그인 확인을 위한 사용자 조회)
-API Gateway 수정 ( user-service 분할 및 filter RewritePath 추가)

-JWT Token 생성
AuthenticationFilter.java
	attemptAuthentication()
		|
UsernamePasswordAuthenticationToken
		|
UserDetailService.java
	loadUserByUsername()
		|———————————————————> UserRepository.java———>DB
		User						findByEmail()	
		|							
AuthenticationFilter.java
	successfulAuthentication(){
	….					——————->UserService.java—————>DB
		UserDTO					getUserDetailsByEmail()
	Jwts.builder()
	response.addHeader(“token”,jwt) 
	}

[GitHub - jwtk/jjwt: Java JWT: JSON Web Token for Java and Android](https://github.com/jwtk/jjwt#jws-create-key)


이전 세션과 쿠키를 이용한 사용자 인증 방식은 모바일 어플리케이션에서 유효하게 사용할 수 없다. 즉 디바이스별로 공유가 안된다.
이러한 문제를 해결하기 위해 Token 기반 인증 시스템으로 처리한다.

JWT	 
-클라이언트 독립적인 서비스
-CDN
-No Cookie-Session(No CSRF, 사이트간 요청 위조)
-지속적인 토큰 저장

gateway-service에 Token 검증 AuthorizationHeaderFilter  추가
-JWT  Parsing 작업 추가
























#SpringCloud


