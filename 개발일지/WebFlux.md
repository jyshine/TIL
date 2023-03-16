# WebFlux 

## Spring HTTP 요청 처리 모듈 

```
1.스프링 MVC (Spring MVC) : 스프링에서 가장 오래된 모듈 중 하나로, 동기 방식으로 HTTP 요청을 처리하는 모델입니다.
	
2.스프링 WebFlux (Spring WebFlux) : 비동기 및 반응형 웹 애플리케이션 개발을 위한 모듈로, Reactor 라이브러리를 기반으로 하며 Mono와 Flux 데이터 타입을 제공합니다.
	
3.스프링 Web Services (Spring Web Services) : SOAP 프로토콜을 기반으로 하는 웹 서비스 개발을 위한 모듈입니다.

4.스프링 REST Docs (Spring REST Docs) : RESTful API의 문서화를 지원하는 모듈로, 테스트 기반 문서화(Test-driven documentation)를 제공합니다.

5.스프링 HATEOAS (Spring HATEOAS) : HATEOAS(Hypermedia as the Engine of Application State) 원칙을 따르는 RESTful API 개발을 지원하는 모듈입니다. Hypermedia를 이용하여 API와 클라이언트 사이의 상호작용을 증진시킵니다.

이 외에도 스프링에서는 다양한 HTTP 요청 처리 관련 모듈들을 제공하고 있습니다. 개발자는 프로젝트의 요구사항에 따라 적합한 모듈을 선택하여 사용할 수 있습니다.

```

![](WebFlux/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202023-03-16%20%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE%2012.54.05.png)

- - - -
## Why was Spring WebFlux created? 
출처([Spring | Home](https://docs.spring.io/))

```
Spring WebFlux was created to provide a reactive web programming model for Spring applications. Traditional Spring MVC framework, which is based on the Servlet API, is designed for blocking I/O and thread-per-request execution model. This means that each incoming request creates a new thread that blocks while waiting for I/O operations to complete, and the number of threads that can be created is limited by the available resources of the server.

However, with the growing demand for high-performance, scalable, and responsive applications, traditional blocking I/O model became a bottleneck in the application's ability to handle large volumes of concurrent requests. Reactive programming, on the other hand, allows developers to build non-blocking, event-driven, and efficient applications that can handle a large number of concurrent requests with a limited number of threads.

Therefore, Spring WebFlux was created to provide a reactive programming model for Spring applications that are designed to handle large volumes of traffic, concurrency, and high throughput. WebFlux is built on top of the Reactor library and supports both reactive streams and reactive programming models, which makes it an ideal choice for developing reactive web applications.

```
- - - -
## WebFlux란 ?

```
Webflux는 스프링 프레임워크의 모듈 중 하나로서, 비동기(non-blocking) 및 반응형(reactive) 웹 애플리케이션 개발을 위한 기능을 제공합니다.
기존의 스프링 MVC 모델은 동기(synchronous) 방식으로 HTTP 요청을 처리하는 구조였지만, Webflux는 비동기 방식으로 HTTP 요청을 처리합니다. 이를 통해 높은 성능과 확장성을 갖춘 반응형 웹 애플리케이션을 개발할 수 있습니다.
Webflux는 Reactor라는 라이브러리를 기반으로 하며, Mono와 Flux라는 데이터 타입을 제공합니다. Mono는 0 또는 1개의 결과를 반환하며, Flux는 0개 이상의 결과를 반환합니다. 이러한 데이터 타입을 사용하여 비동기적으로 데이터를 처리할 수 있습니다.

Webflux는 또한 함수형 프로그래밍을 지원하며, 람다식을 활용한 코드 작성이 가능합니다. 이러한 기능들은 높은 성능을 요구하는 웹 애플리케이션 개발에서 매우 유용합니다.

```

- - - -
## WebFlux의 확장성이란?

```
WebFlux의 확장성은 매우 뛰어납니다. WebFlux는 비동기적인 방식으로 요청을 처리하기 때문에, 요청당 할당되는 스레드 수를 크게 줄일 수 있습니다. 이를 통해 서버가 처리할 수 있는 요청의 수가 높아지며, 처리량이 대폭 증가합니다. 또한, WebFlux는 Reactor 라이브러리를 기반으로 하기 때문에, 멀티 코어 환경에서도 높은 처리 능력을 유지할 수 있습니다.

WebFlux는 이러한 확장성을 위해 다음과 같은 기술을 활용합니다.

1.Reactive Streams : Reactive Streams는 비동기적인 데이터 스트림 처리를 위한 표준 인터페이스를 제공합니다. WebFlux는 Reactive Streams를 지원하여, 다양한 백프레임워크와 함께 사용할 수 있습니다.
	
2.Reactor : Reactor는 Reactive Streams를 구현하는 자바 라이브러리 중 하나로, WebFlux에서 비동기적인 데이터 스트림 처리를 위해 사용됩니다. Reactor는 Publisher-Subscriber 모델을 기반으로 하며, Mono와 Flux라는 두 가지 데이터 타입을 제공합니다.

3.Netty : Netty는 비동기적인 네트워크 프로그래밍을 위한 자바 라이브러리로, WebFlux에서 HTTP 요청 처리를 위해 사용됩니다. Netty는 높은 처리량과 낮은 지연 시간을 유지할 수 있는 고성능 네트워크 프레임워크입니다.
이러한 기술들을 활용하여 WebFlux는 높은 처리 능력과 확장성을 갖춘 반응형 웹 애플리케이션 개발을 가능하게 합니다.

```

- - - -
## WebFlux의 단점?

```
WebFlux는 매우 높은 처리량과 확장성을 갖는 반응형 웹 애플리케이션 개발을 가능하게 해주지만, 몇 가지 단점도 있습니다.

	1.학습 곡선이 높음: WebFlux는 기존의 스프링 MVC와는 매우 다른 개념을 기반으로 하고 있어서, 학습 곡선이 높을 수 있습니다. 특히, 비동기 및 반응형 프로그래밍에 대한 이해가 필요합니다.
	
2.코드 복잡도가 높음: WebFlux는 함수형 프로그래밍을 지원하며, 람다식을 활용한 코드 작성이 가능합니다. 하지만, 이를 사용하기 위해서는 개발자가 함수형 프로그래밍에 대한 이해가 필요하며, 코드 복잡도가 높아질 수 있습니다.

3.스프링 생태계와의 호환성 문제: WebFlux는 스프링 생태계 내에서 독립적으로 동작하기 때문에, 기존의 스프링 모듈들과의 호환성 문제가 발생할 수 있습니다. 예를 들어, 스프링 시큐리티(Spring Security)와 같은 보안 모듈에서 일부 설정이 변경되어야 할 수 있습니다.
	
4.CPU 사용량이 높음: WebFlux는 비동기 방식으로 HTTP 요청을 처리하기 때문에, CPU 사용량이 높을 수 있습니다. 이는 기존의 스프링 MVC와 비교하여 서버의 처리 능력을 높이는 대신 서버의 리소스를 더 많이 사용하게 됩니다.
이러한 WebFlux의 단점들은 프로젝트의 요구사항에 따라 다르게 인식될 수 있습니다. 따라서 개발자는 프로젝트의 특성을 고려하여 WebFlux를 적절하게 활용해야 합니다.

```

- - - -
## Mono Type

```
Mono는 Reactor 라이브러리에서 제공하는 타입 중 하나로, 0 또는 1개의 결과를 비동기적으로 생성하거나 처리할 수 있습니다. 즉, Mono는 한 개의 결과만을 처리하는데, 결과가 없을 수도 있고, 오직 한 개만 있을 수도 있습니다.
Mono는 Publisher 인터페이스를 구현하여 데이터 스트림 처리를 가능하게 합니다. 또한, map(), flatMap(), filter() 등의 연산자를 제공하여 데이터를 가공하고 조합할 수 있습니다.

```

- - - -
## Reactor

```
Reactor는 Pivotal이 개발한 Reactive Stream을 구현한 Java 8+에서 사용할 수 있는 리액티브 프로그래밍 라이브러리입니다. Reactor는 Flux와 Mono 두 가지 타입을 제공하여 비동기적으로 데이터를 처리하고, 리액티브 프로그래밍 패턴을 적용할 수 있도록 돕습니다.

**Flux**는 0개 이상의 결과를 비동기적으로 처리할 수 있는 타입으로, 데이터를 스트림으로 처리하며 map(), filter(), reduce() 등 다양한 연산자를 제공합니다. Flux를 사용하면 데이터 스트림을 생성하고, 중간 처리 및 최종 처리를 비동기적으로 수행할 수 있습니다.

**Mono**는 0 또는 1개의 결과를 비동기적으로 처리할 수 있는 타입으로, Flux와 유사하지만 한 개의 결과만을 처리합니다. Mono는 Flux에서 사용하는 연산자들을 모두 사용할 수 있습니다.

Reactor는 Reactive Stream 표준을 따르므로 다른 Reactive Stream 구현체와도 호환성이 좋습니다. 또한, Spring 프레임워크에서도 사용되어 비동기적인 HTTP 요청 처리에 적합합니다.

Reactor를 사용하면 비동기적으로 데이터를 처리하고, 데이터 스트림을 조합하여 다양한 비즈니스 로직을 구현할 수 있습니다. Reactor는 스레드 세이프하며, 백프레셔(Backpressure) 기능을 지원하여 안정적인 시스템을 구축할 수 있도록 돕습니다.

```

- - - -
## Reactor Programing Library

```
리액티브 프로그래밍 라이브러리는 Reactive Stream 표준을 구현하여 비동기적인 데이터 처리를 지원하는 라이브러리입니다. Reactive Stream은 비동기 데이터 처리의 표준을 정의한 것으로, Reactive Stream을 구현한 라이브러리는 서로 호환성이 있습니다.

리액티브 프로그래밍 라이브러리는 비동기적으로 데이터를 처리할 때 발생할 수 있는 문제를 해결할 수 있는 다양한 기능을 제공합니다. 예를 들어, 백프레셔(Backpressure) 기능을 제공하여 데이터의 생산 속도와 소비 속도를 조절하여 안정적인 시스템을 구축할 수 있습니다.

Reactor는 Pivotal에서 개발한 리액티브 프로그래밍 라이브러리로, Reactive Stream을 구현하여 비동기적인 데이터 처리를 지원합니다. ReactiveX는 Reactive Stream을 기반으로 만들어진 리액티브 프로그래밍 라이브러리로, 다양한 언어와 플랫폼에서 사용할 수 있습니다.

그 외에도 RxJava, Akka, Vert.x 등 다양한 리액티브 프로그래밍 라이브러리가 있습니다. 이러한 라이브러리를 사용하면, 스레드를 블록하지 않고 비동기적으로 데이터를 처리하고, 안정적인 시스템을 구축할 수 있습니다.

```



#webflux