# Security Filters

    - Security Filters는 SecurityFilterChain API를 사용하여 FilterChainProxy에 삽입됩니다.
    - 이러한 필터들은 인증, 권한 부여, 공격 방어 등과 같은 여러 목적으로 사용될 수 있습니다. (authentication, authorization, exploit protection ..)
    - 필터들은 올바른 순서로 실행되어야 하기 때문에 특정한 순서로 실행됩니다. 예를 들어, 인증을 수행하는 필터는 권한 부여를 수행하는 필터보다 먼저 호출되어야 합니다.
    - Spring Security의 필터 순서를 명시적으로 알 필요는 없습니다. 
    - 대부분의 경우 Spring Security가 제공하는 기본 구성을 사용하면 필터가 올바른 순서로 실행됩니다. 
    - 필요한 경우 사용자 지정 필터를 추가하고자 할 때에만 필터 순서에 대해 고려해야 합니다.
   ```
    @Configuration
    @EnableWebSecurity
    public class SecurityConfig {

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            http
                .csrf(Customizer.withDefaults())
                .authorizeHttpRequests(authorize -> authorize
                    .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults());
            return http.build();
        }

    }
    
    # 첫째로, CSRF 공격을 방지하기 위해 CsrfFilter가 호출됩니다.
    # 둘째로, 인증 필터가 호출되어 요청을 인증합니다.
    # 셋째로, 권한 부여 필터가 호출되어 요청을 승인합니다.
   ```

   ```
    Filter	                                Added by
    CsrfFilter                              HttpSecurity#csrf
    UsernamePasswordAuthenticationFilter    HttpSecurity#formLogin
    BasicAuthenticationFilter               HttpSecurity#httpBasic
    AuthorizationFilter                     HttpSecurity#authorizeHttpRequests
   ```

    - [FilterOrderRegistration](https://github.com/spring-projects/spring-security/blob/6.1.4/config/src/main/java/org/springframework/security/config/annotation/web/builders/FilterOrderRegistration.java)