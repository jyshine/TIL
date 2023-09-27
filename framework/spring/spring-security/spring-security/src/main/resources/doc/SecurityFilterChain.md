# SecurityFilterChain.md
    - SecurityFilterChain은 FilterChainProxy에 의해 사용되며 현재 요청에 대해 호출해야 할 Spring Security Filter 인스턴스를 결정하는 데 사용됩니다.

![securityfilterchain.png](https://github.com/jyshine/TIL/blob/main/framework/spring/spring-security/spring-security/src/main/resources/img/securityfilterchain.png)

- SecurityFilterChain의 Security Filters 는 일반적인 Beans 입니다. 
- 하지만 DelegatingFilterProxy가 아닌 FilterChainProxy에 등록합니다.
- FilterChainProxy는 서블릿 컨테이너나 DelegatingFilterProxy와 직접 등록하는 것과 비교해 여러 이점을 제공합니다.
  - 첫째, 모든 Spring Security의 서블릿 지원의 시작점을 제공한다. 즉 Security의 서블릿 지원을 문제 해결하려는 경우 FilterChainProxy에 디버그 포인트를 추가하여 확인 가능합니다.
  - 둘째, FilterChainProxy가 Spring Security 사용에서 중요한 위치를 차지하고 있기 때문에 선택 사항으로 간주되지 않는 작업을 수행할 수 있습니다.
    예를 들어, 이는 메모리 누수를 피하기 위해 SecurityContext를 초기화하거나, 특정 유형의 공격으로부터 응용 프로그램을 보호하기 위해 Spring Security의 HttpFirewall을 적용하는 등의 작업을 수행할 수 있습니다.
  - 셋째, SecurityFilterChain이 호출되어야 하는지를 결정하는 데 더 많은 유연성을 제공합니다
    서블릿 컨테이너에서 Filter 인스턴스는 URL을 기반으로 호출됩니다. 
    그러나 FilterChainProxy는 RequestMatcher 인터페이스를 사용하여 HttpServletRequest의 모든 것을 기반으로 호출 여부를 결정할 수 있습니다.




![multi-securityfilterchain.png](https://github.com/jyshine/TIL/blob/main/framework/spring/spring-security/spring-security/src/main/resources/img/multi-securityfilterchain.png)

- FilterChainProxy는 어떤 SecurityFilterChain을 사용할지 결정합니다. 일치하는 첫 번째 SecurityFilterChain만 호출됩니다.
- 예를들어 URL로 /api/messages/를 요청하면 먼저 /api/** 패턴인 SecurityFilterChain0에 일치하므로 SecurityFilterChain0만 호출됩니다.
- URL로 /messages/가 요청되면 /api/** 패턴인 SecurityFilterChain0과 일치하지 않으므로 FilterChainProxy는 각 SecurityFilterChain을 계속해서 시도합니다.
- 다른 SecurityFilterChain 인스턴스가 일치하지 않는 경우, SecurityFilterChainn이 호출됩니다.
- 그림에 보면 SecurityFilterChain0 은 3개의 security Filter SecurityFilterChainN에는 4개의 security Filter가 있습니다.
- 각 SecurityFilterChain가 고유하며 독립적으로 구성될 수 있다는 것을 알아두는 것이 중요합니다.
- 특정 요청을 Spring Security가 무시하도록 원하는 경우에는 SecurityFilterChain에 보안 필터 인스턴스가 없을 수도 있습니다.