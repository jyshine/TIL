# Saving Requests Between Authentication

- Handling Security Exception 에서 설명한 대로, 인증되지 않은 상태로 보안이 필요한 리소스에 대한 요청이 올 경우, 
- 인증이 성공한 후 해당 리소스를 다시 요청하기 위해 요청을 저장할 필요가 있습니다. 
- Spring Security에서는 이를 달성하기 위해 HttpServletRequest를 RequestCache 구현을 사용하여 저장합니다.

- RequestCache는 요청과 관련된 정보를 유지하고, 인증이 성공한 후에 이 정보를 사용하여 원래 요청을 다시 생성할 수 있게 해줍니다. 
- 이를 통해 사용자는 로그인 페이지로 리디렉션된 후, 원래 요청을 자동으로 다시 보낼 수 있어, 사용자 경험을 향상시키는 데 도움이 됩니다.

## RequestCache
- HttpServletRequest는 RequestCache에 저장됩니다. 
- 사용자가 성공적으로 인증되면 RequestCache를 사용하여 원래 요청을 다시 실행하는 데 사용됩니다. 
- RequestCacheAwareFilter는 HttpServletRequest를 저장하기 위해 RequestCache를 사용합니다.
```
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .requestCache()
                .requestCache(customRequestCache()); // Use custom RequestCache implementation
            // ... other security configurations ...
    }

    @Bean
    public RequestCache customRequestCache() {
        return new CustomRequestCache(); // Implement your custom RequestCache here
    }
}

/**
위의 코드에서 CustomRequestCache 클래스는 RequestCache 인터페이스를 구현하여 HttpSession에서 요청을 저장하고 검색하는 사용자 정의 로직을 정의해야 합니다. 
이를 통해 http.requestCache().requestCache(customRequestCache())를 사용하여 원하는 방식으로 요청을 관리할 수 있습니다.
**/
```


- 기본적으로 HttpSessionRequestCache가 사용됩니다. 
- 아래 코드는 continue라는 이름의 파라미터가 있을 때 HttpSession에서 저장된 요청을 확인하는 데 사용되는 RequestCache 구현을 사용자 정의하는 방법을 보여줍니다:
```
  @Bean
  DefaultSecurityFilterChain springSecurity(HttpSecurity http) throws Exception {
    HttpSessionRequestCache requestCache = new HttpSessionRequestCache();
    requestCache.setMatchingRequestParameterName("continue");
    http
        // ...
        .requestCache((cache) -> cache
        .requestCache(requestCache)
        );
    return http.build();
  }
  
  /** 
  RequestCache는 저장된 요청을 확인하는 것을 continue 파라미터가 존재할 때만 체크합니다. 
  이 말은 사용자가 인증되지 않은 상태로 보호된 리소스에 접근하려고 할 때 저장된 요청이 세션에 있고, 
  그리고 요청 파라미터에 continue가 포함되어 있다면 그 요청을 재실행할 것이라는 뜻입니다. 
  이렇게 하면 사용자가 로그인 또는 인증을 마친 후에, 원래 요청된 리소스로 자동으로 리디렉션됩니다.
  **/
```

## Prevent the Request From Being Saved
- 요청이 저장되지 않도록 방지하려면 continue 매개변수가 없는 경우 RequestCache를 사용하지 않으면 됩니다. 
- 이렇게 하면 저장된 요청이 없으므로 사용자가 성공적으로 인증된 후에도 원래 요청된 리소스로 자동으로 리디렉션되지 않습니다.
- 사용자의 인증되지 않은 요청을 세션에 저장하지 않는 이유는 여러 가지가 있을 수 있습니다. 
- 이를 사용자의 브라우저에 저장하거나 데이터베이스에 저장하고자 할 수 있습니다. 
- 또는 항상 사용자를 로그인 전에 방문하려고 했던 페이지가 아닌 홈 페이지로 리디렉션하고 싶어서 이 기능을 끄고 싶을 수도 있습니다.

```
@Bean
SecurityFilterChain springSecurity(HttpSecurity http) throws Exception {
    RequestCache nullRequestCache = new NullRequestCache();
    http
        // ...
        .requestCache((cache) -> cache
            .requestCache(nullRequestCache)
        );
    return http.build();
}
```

- RequestCacheAwareFilter는 HttpServletRequest를 저장하기 위해 RequestCache를 사용합니다