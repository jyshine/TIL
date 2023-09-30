# Logging

Spring Security는 모든 보안 관련 이벤트에 대한 포괄적인 로깅을 DEBUG 및 TRACE 레벨에서 제공합니다.
특히, 애플리케이션 디버깅할 때 매우 유용합니다.
Spring Security는 왜 요청이 거부되었는지 자세한 response body 내용을 추가하지 않습니다.
만약 401 또는 403 오류가 발생하면 관련된 log message를 찾을 수 있어 상황 이해하는데 도움이 됩니다.



로그가 없는 상태에서 사용자가 CSRF 토큰 없이 POST 요청을 시도하는 상황을 예로 살펴봅시다.
그 사용자는 요청이 거부된 이유에 대한 설명 없이 403 오류를 볼 것입니다. 
Spring Security의 로깅을 활성화하면 다음과 같은 로그 메시지를 볼 수 있습니다:

   ```
2023-06-14T09:44:25.797-03:00 DEBUG 76975 --- [nio-8080-exec-1] o.s.security.web.FilterChainProxy        : Securing POST /hello
2023-06-14T09:44:25.797-03:00 TRACE 76975 --- [nio-8080-exec-1] o.s.security.web.FilterChainProxy        : Invoking DisableEncodeUrlFilter (1/15)
2023-06-14T09:44:25.798-03:00 TRACE 76975 --- [nio-8080-exec-1] o.s.security.web.FilterChainProxy        : Invoking WebAsyncManagerIntegrationFilter (2/15)
2023-06-14T09:44:25.800-03:00 TRACE 76975 --- [nio-8080-exec-1] o.s.security.web.FilterChainProxy        : Invoking SecurityContextHolderFilter (3/15)
2023-06-14T09:44:25.801-03:00 TRACE 76975 --- [nio-8080-exec-1] o.s.security.web.FilterChainProxy        : Invoking HeaderWriterFilter (4/15)
2023-06-14T09:44:25.802-03:00 TRACE 76975 --- [nio-8080-exec-1] o.s.security.web.FilterChainProxy        : Invoking CsrfFilter (5/15)
2023-06-14T09:44:25.814-03:00 DEBUG 76975 --- [nio-8080-exec-1] o.s.security.web.csrf.CsrfFilter         : Invalid CSRF token found for http://localhost:8080/hello
2023-06-14T09:44:25.814-03:00 DEBUG 76975 --- [nio-8080-exec-1] o.s.s.w.access.AccessDeniedHandlerImpl   : Responding with 403 status code
2023-06-14T09:44:25.814-03:00 TRACE 76975 --- [nio-8080-exec-1] o.s.s.w.header.writers.HstsHeaderWriter  : Not injecting HSTS header since it did not match request to [Is Secure]
   ```

요청이 거부된 이유는 CSRF 토큰이 누락되었기 때문이라는 것이 명확해집니다.

   ```
   application.properties in Spring Boot
    logging.level.org.springframework.security=TRACE
    
    Copied!
    logback.xml
    <configuration>
        <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
            <!-- ... -->
        </appender>
        <!-- ... -->
        <logger name="org.springframework.security" level="trace" additivity="false">
            <appender-ref ref="Console" />
        </logger>
    </configuration>
   ```