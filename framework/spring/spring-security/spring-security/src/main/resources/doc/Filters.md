# Filters

![filterchain.png](https://github.com/jyshine/TIL/blob/main/framework/spring/spring-security/spring-security/src/main/resources/img/filterchain.png)

- Spring Security 의 서블릿 지원은 Servlet Filters를 기반으로 한다.

- 클라이언트는 애플리케이션에 요청을 보내고 Container는 FilterChain을 생성한다. 
- URI 요청의 경로 기반으로 HttpServletRequest를 처리해야 하는 Filter 인스턴스 및 Servlet이 포함한다.
- Spring MVC 애플리케이션에서 Servlet은 DispatcherServlet의 인스턴스
- 최대 하나의 Servlet이 단일 HttpServletRequest와 HttpServletResponse를 처리
- 다운스트림(Filter 체인 내에서 현재 Filter의 하위에 있는) Filter instances 또는 Servlet이 호출되지 않도록 막는 것은 Spring Security와 같은 보안 필터에서 자주 사용되는 패턴 중 하나
- Filter는 하향 스트림 Filter 인스턴스와 Servlet에만 영향을 미치기 때문에 각 Filter가 호출되는 순서가 중요하다.
- 인스턴스와 Servlet에서 사용되는 HttpServletRequest 또는 HttpServletResponse를 수정
   ```
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
    // do something before the rest of the application
    chain.doFilter(request, response); // invoke the rest of the application
    // do something after the rest of the application
    }
   ```
    
