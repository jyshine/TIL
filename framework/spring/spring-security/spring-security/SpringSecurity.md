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
      - [CSRF](https://github.com/jyshine/TIL/blob/main/framework/spring/spring-security/spring-security/src/main/resources/doc/CSRF.md)
      - [HTTP Headers](https://github.com/jyshine/TIL/blob/main/framework/spring/spring-security/spring-security/src/main/resources/doc/HTTPHeaders.md)
      - [HTTP Requests](https://github.com/jyshine/TIL/blob/main/framework/spring/spring-security/spring-security/src/main/resources/doc/HTTPHeaders.md)
  
- Integrations
  - Cryptography
  - Spring Data
  - Java's Concurrency APIs
  - Jackson
  - Localization
  
### Architecture
- [A Review of Filters](https://github.com/jyshine/TIL/blob/main/framework/spring/spring-security/spring-security/src/main/resources/doc/Filters.md)
- [DelegatingFilterProxy](https://github.com/jyshine/TIL/blob/main/framework/spring/spring-security/spring-security/src/main/resources/doc/DelegatingFilterProxy.md)
- [FilterChainProxy](https://github.com/jyshine/TIL/blob/main/framework/spring/spring-security/spring-security/src/main/resources/doc/FilterChainProxy.md)
- [SecurityFilterChain](https://github.com/jyshine/TIL/blob/main/framework/spring/spring-security/spring-security/src/main/resources/doc/SecurityFilterChain.md)
- [Security Filters](https://github.com/jyshine/TIL/blob/main/framework/spring/spring-security/spring-security/src/main/resources/doc/SecurityFilters.md)
- [Adding a Custom Filter to the Filter Chain](https://github.com/jyshine/TIL/blob/main/framework/spring/spring-security/spring-security/src/main/resources/doc/CustomFilter.md)
- [Handling Security Exceptions](https://github.com/jyshine/TIL/blob/main/framework/spring/spring-security/spring-security/src/main/resources/doc/HandlingSecurityExceptions.md)
- [Saving Requests Between Authentication](https://github.com/jyshine/TIL/blob/main/framework/spring/spring-security/spring-security/src/main/resources/doc/SavingRequestsBetweenAuthentication.md)
- [Logging](https://github.com/jyshine/TIL/blob/main/framework/spring/spring-security/spring-security/src/main/resources/doc/Logging.md)

  
### Servlet Authentication Architecture
- SecurityContextHolder - SecurityContextHolder는 누가 인증되었는지에 대한 세부 정보를 Spring Security에서 저장하는 곳입니다.
- SecurityContext - SecurityContextHolder에서 얻어지며 현재 인증된 사용자의 Authentication을 포함합니다.
- Authentication - AuthenticationManager의 입력으로 사용되어 사용자가 인증을 위해 제공한 자격 증명이나 SecurityContext에서 현재 사용자입니다.
- GrantedAuthority - Authentication에 부여된 권한(예: 역할, 범위 등)
- AuthenticationManager - Spring Security의 필터가 인증을 수행하는 방법을 정의한 API입니다.
- ProviderManager - AuthenticationManager의 가장 일반적인 구현입니다.
- AuthenticationProvider - ProviderManager에서 특정 유형의 인증을 수행하기 위해 사용됩니다.
- AuthenticationEntryPoint을 사용하여 자격 증명 요청 - 클라이언트로부터 자격 증명을 요청하기 위해 사용됩니다(예: 로그인 페이지로 리디렉션, WWW-Authenticate 응답을 보내기 등).
- AbstractAuthenticationProcessingFilter - 인증에 사용되는 기본 필터입니다. 이것은 또한 인증의 고수준 흐름과 각 부분이 어떻게 함께 작동하는지에 대한 좋은 개요를 제공합니다.

