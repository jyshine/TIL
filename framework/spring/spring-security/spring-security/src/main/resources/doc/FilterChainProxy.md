# FilterChainProxy
- Spring Security의 서블릿 지원 기능은 FilterChainProxy에 포함되어 있습니다.
- FilterChainProxy는 Spring Security에서 제공하는 특별한 Filter로, SecurityFilterChain을 통해 여러 개의 Filter 인스턴스로 위임할 수 있도록 합니다
- FilterChainProxy는 일반적으로 DelegatingFilterProxy로 래핑됩니다.