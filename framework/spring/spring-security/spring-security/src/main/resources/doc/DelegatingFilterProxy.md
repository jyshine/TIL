# DelegatingFilterProxy


- DelegatingFilterProxy라는 Filter 구현을 제공
- 이 필터는 Servlet 컨테이너의 라이프사이클과 Spring의 ApplicationContext 간의 연결을 가능하게 하는 역할
- 서블릿 컨테이너는 자체 표준을 사용하여 필터 인스턴스를 등록할 수 있지만 Spring에서 정의한 빈(Bean)들에 대해 인식하지는 않습니다.
- DelegatingFilterProxy를 표준 서블릿 컨테이너 메커니즘을 통해 등록할 수 있지만 모든 작업을 Filter를 구현한 Spring Bean으로 위임할 수 있습니다.

- ![delegatingfilterproxy.png](https://github.com/jyshine/TIL/blob/main/framework/spring/spring-security/spring-security/src/main/resources/img/delegatingfilterproxy.png)
- DelegatingFilterProxy는 ApplicationContext에서 Bean Filter0을 찾은 다음 Bean Filter0을 호출
   ```
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
    Filter delegate = getFilterBean(someBeanName); // 1
    delegate.doFilter(request, response); // 2
    }
     // 1. Lazily get Filter that was registered as a Spring Bean
     //    DelegatingFilterProxy의 예에서 delegate는 Bean Filter0의 인스턴스입니다.
     // 2. Spring Bean에 작업을 위임
  
   ```
