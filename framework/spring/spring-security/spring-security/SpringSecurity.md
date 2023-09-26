# Getting Started

### Reference Documentation
* [Spring Security](https://docs.spring.io/spring-security/)

Spring Security provides comprehensive support for authentication, authorization and protection against common exploits.
It also provides integration with other libraries to simplify its usage.

스프링 시큐리티는 인증과 권한 부여 그리고 일반적인 공격에 대한 보호 포괄적인 지원을 제공합니다.
또한, 다른 라이브러리와 통합을 제공하여 사용을 간소화 합니다.

### 주요 특징

- Authentication :
  - Spring Security는 인증에 대한 포괄적인 지원을 제공합니다. 
  - 인증은 특정 리소스에 액세스하려는 사용자의 신원을 확인하는 방법입니다. 
  - 사용자를 인증하는 일반적인 방법은 사용자가 사용자 이름과 비밀번호를 입력하도록 요구하는 것입니다. 
  - 인증이 수행되면 우리는 사용자의 신원을 알고 권한 부여를 수행할 수 있게 됩니다.
    - [Password Storage](https://github.com/jyshine/TIL/blob/main/framework/spring/spring-security/spring-security/src/main/resources/doc/PasswordStorage.md) 
    
- Protection Against Exploits
  - 일반적인 보안 취약점에 대한 보호를 제공합니다. 가능한 경우, 이러한 보호 기능은 기본적으로 활성화되어 있습니다.
      - CSRF
      - HTTP Headers
      - HTTP Requests
  
- Integrations
