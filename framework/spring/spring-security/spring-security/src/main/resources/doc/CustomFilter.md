# Adding a Custom Filter to the Filter Chain

    - 대부분의 경우는 기본 보안 필터로만 애플리케이션 보호하는 데 충분합니다.
    - 하지만 Security Filter Chain에 사용자 정의 필터를 추가할 수 있습니다.

```
    /** 
    예를 들어, 특정 테넌트 ID 헤더를 가져오고 현재 사용자가 해당 테넌트에 액세스할 수 있는지 확인하는 필터를 추가하려고 합니다. 
    이전 설명에서 이미 어디에 필터를 추가해야 하는지에 대한 힌트를 얻었습니다. 
    현재 사용자를 알아야 하므로 이를 인증 필터 이후에 추가해야 합니다.
    **/
    
    public class TenantFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String tenantId = request.getHeader("X-Tenant-Id"); 
        boolean hasAccess = isUserAllowed(tenantId); 
        if (hasAccess) {
            filterChain.doFilter(request, response); 
            return;
        }
        throw new AccessDeniedException("Access denied"); 
    }

}

# 요청 헤더에서 테넌트 ID를 가져옵니다.
# 현재 사용자가 해당 테넌트 ID에 액세스할 수 있는지 확인합니다.
# 사용자가 액세스 권한을 가지고 있다면 체인 내의 나머지 필터를 호출합니다.
# 사용자가 액세스 권한을 가지고 있지 않다면 AccessDeniedException을 throw합니다.

```


Filter를 구현하는 대신, OncePerRequestFilter를 확장할 수 있습니다. 
OncePerRequestFilter는 각 요청당 한 번만 호출되는 필터에 대한 기본 클래스이며 HttpServletRequest 및 HttpServletResponse 
매개변수를 사용하는 doFilterInternal 메서드를 제공합니다. 
이 방법을 사용하면 더 쉽게 사용자 정의 필터를 구현할 수 있습니다.

```
@Bean
SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
        // ...
        .addFilterBefore(new TenantFilter(), AuthorizationFilter.class); 
    return http.build();
}

# HttpSecurity#addFilterBefore를 사용하여 TenantFilter를 AuthorizationFilter 앞에 추가할 수 있습니다. 
# 이렇게하면 TenantFilter가 인증 필터 이후에 실행되고 권한 필터 이전에 실행됩니다. 
# 이 방법을 사용하여 필터 체인에서 사용자 정의 필터의 위치를 지정할 수 있습니다.

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private TenantFilter tenantFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .addFilterBefore(tenantFilter, UsernamePasswordAuthenticationFilter.class)
            .authorizeRequests()
                .antMatchers("/public/**").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
            .logout()
                .permitAll();
    }
}
```
```
/**
TenantFilter를 AuthorizationFilter 이후에 추가함으로써 TenantFilter가 인증 필터 이후에 실행되도록 합니다. 
또한 HttpSecurity#addFilterAfter를 사용하여 특정 필터 이후에 필터를 추가하거나 
HttpSecurity#addFilterAt를 사용하여 필터 체인에서 특정 위치에 필터를 추가할 수도 있습니다. 
이렇게하면 필터 체인에서 필터의 위치를 명시적으로 지정할 수 있습니다.

다음으로, TenantFilter는 필터 체인에서 호출되어 현재 사용자가 테넌트 ID에 액세스 권한이 있는지 확인합니다.
필터를 Spring 빈으로 선언할 때 주의해야 합니다. 
@Component로 주석을 달거나 구성에서 빈으로 선언함으로써 Spring Boot는 자동으로 내장 컨테이너에 필터를 등록합니다. 
이로 인해 필터가 컨테이너와 Spring Security에 의해 두 번 호출될 수 있습니다. 
이중 호출을 피하려면 Spring Boot에 필터를 컨테이너에 등록하지 않도록 지시할 수 있습니다. 
이를 위해 FilterRegistrationBean 빈을 선언하고 enabled 속성을 false로 설정합니다. 
이렇게하면 필터가 Spring Security에서만 한 번 호출됩니다.

**/


@Bean
public FilterRegistrationBean<TenantFilter> tenantFilterRegistration(TenantFilter filter) {
    FilterRegistrationBean<TenantFilter> registration = new FilterRegistrationBean<>(filter);
    registration.setEnabled(false);
    return registration;
}
```