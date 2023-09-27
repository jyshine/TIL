# HTTP
    모든 HTTP 기반 통신, 정적 리소스를 포함한 모든 것은 TLS를 사용하여 보호해야 합니다.
    Spring Security는 HTTP 연결을 처리하지 않으며 따라서 HTTPS에 대한 직접적인 지원은 제공하지 않습니다. 그러나 HTTPS 사용을 돕는 여러 기능을 제공합니다.
    
    TLS :  Transport Layer Security
    컴퓨터 네트워크에서 데이터 통신을 보호하기 위한 프로토콜 및 기술의 집합
    TLS는 데이터를 암호화하고 통신 상대방과의 안전한 연결을 설정하여 중간자 공격 및 데이터 도난을 방지

# Redirect to HTTPS
    클라이언트가 HTTP를 사용할 때, Spring Security를 구성하여 Servlet 및 WebFlux 환경 모두에서 HTTPS로 리디렉션할 수 있습니다.
    ```
    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;
    import org.springframework.security.config.annotation.web.builders.HttpSecurity;
    import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
    import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
    
    @Configuration
    @EnableWebSecurity
    public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                .requiresChannel()
                    .antMatchers("/secure/**").requiresSecure() // Redirect to HTTPS for /secure/** URLs
                    .and()
                .authorizeRequests()
                    .antMatchers("/public/**").permitAll()
                    .antMatchers("/secure/**").authenticated()
                    .and()
                .formLogin()
                    .and()
                .logout()
                    .permitAll();
        }
    }

    ```
# Strict Transport Security
    Strict Transport Security를 지원하며 기본적으로 활성화됩니다.

# Proxy Server Configuration
    
    Spring 사용자는 ForwardedHeaderFilter를 사용할 수 있습니다.
    Spring Boot 사용자는 server.use-forward-headers 속성을 사용하여 애플리케이션을 구성할 수 있습니다. 
     
    ```
    # application.properties

    # 프록시 서버의 X-Forwarded 헤더를 허용하도록 설정
    server.use-forward-headers=true
    
    # 로드 밸런서에서 설정한 프록시 서버의 호스트 및 포트 정보
    server.tomcat.remote-ip-header=x-forwarded-for
    server.tomcat.protocol-header=x-forwarded-proto
    server.tomcat.port-header=x-forwarded-port

    ```