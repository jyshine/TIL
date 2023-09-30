# Handling Security Exceptions

![exceptiontranslationfilter](https://github.com/jyshine/TIL/blob/main/framework/spring/spring-security/spring-security/src/main/resources/img/exceptiontranslationfilter.png)

ExceptionTranslationFilter는 AccessDeniedException 및 AuthenticationException을 HTTP 응답으로 변환할 수 있게 해줍니다. 
즉, 액세스 거부 또는 인증 예외가 발생할 때 이를 적절한 HTTP 상태 코드와 함께 클라이언트에게 반환할 수 있도록 도와줍니다. 
이는 Spring Security에서 인증 및 권한 부여 예외를 처리하고 적절한 응답으로 변환하여 사용자에게 전달하는 데 사용됩니다. 
이를 통해 클라이언트는 어떤 종류의 오류가 발생했는지 이해하고 그에 따른 조치를 취할 수 있습니다.


ExceptionTranslationFilter는 FilterChainProxy에 보안 필터로서 삽입됩니다. 
이렇게 함으로써 Spring Security는 액세스 거부 및 인증 예외를 적절한 HTTP 응답으로 변환하여 처리할 수 있습니다. 
FilterChainProxy는 보안 필터들을 관리하고 이러한 필터들을 적절한 순서로 호출하여 보안을 제공합니다. 
ExceptionTranslationFilter는 이 중 하나로써 예외를 처리하는 역할을 합니다.


1. 첫 번째로, ExceptionTranslationFilter는 FilterChain.doFilter(request, response)를 호출하여 애플리케이션의 나머지 부분을 실행합니다.
2. 만약 사용자가 인증되지 않았거나 AuthenticationException이 발생한 경우, 인증 프로세스가 시작됩니다. 이것은 사용자를 인증하고 권한을 부여하는 과정입니다.
   - SecurityContextHolder는 클리어됩니다. 이는 현재 스레드의 보안 컨텍스트를 지워줍니다. 스프링 시큐리티는 각 스레드에 대한 별도의 보안 컨텍스트를 유지하며, 이는 사용자의 인증 상태와 권한 정보를 포함합니다. 인증이 시작되면 이전의 보안 컨텍스트가 지워지고 새로운 인증된 사용자의 정보로 대체됩니다. 이렇게 함으로써 이전 사용자의 세션 정보가 인증 과정에서 누출되지 않도록 보호됩니다.
   - HttpServletRequest는 인증이 성공하면 원래의 요청을 다시 실행하기 위해 저장됩니다. 이는 사용자가 인증되기 전에 요청한 리소스에 대한 접근을 보류시키고, 사용자가 성공적으로 인증되면 해당 요청을 재실행하여 요청한 리소스에 대한 응답을 생성합니다. 이를 통해 사용자는 인증 프로세스가 완료된 후에 원래의 요청에 대한 응답을 받게 됩니다. 
   - AuthenticationEntryPoint는 클라이언트로부터 자격 증명(인증 정보)을 요청하는 역할을 합니다. 이는 클라이언트가 인증되지 않았거나 인증에 실패한 경우 사용자에게 로그인 페이지로 리디렉션하거나 WWW-Authenticate 헤더를 포함하여 인증을 요청할 수 있습니다. 이 방식은 클라이언트가 요청한 자원에 대한 인증이 필요한 경우 클라이언트로부터 인증 정보를 수신하고 검증하기 위해 사용됩니다. 
3. 그렇지 않고 AccessDeniedException이 발생한 경우, "액세스 거부(Access Denied)" 처리가 진행됩니다. 이 경우 AccessDeniedHandler가 호출되어 액세스 거부 상황을 처리합니다. AccessDeniedHandler는 사용자가 특정 자원에 대한 액세스 권한이 없을 때 어떻게 처리할지를 정의합니다. 이를 통해 사용자에게 알림 메시지를 표시하거나 특정 페이지로 리디렉션하는 등의 작업을 수행할 수 있습니다.

```
try {
	filterChain.doFilter(request, response); # 1 
} catch (AccessDeniedException | AuthenticationException ex) {
	if (!authenticated || ex instanceof AuthenticationException) {
		startAuthentication(); 
	} else {
		accessDenied(); 
	}
}


```

#1 "A Review of Filters"에서 설명한대로 FilterChain.doFilter(request, response)를 호출하는 것은 애플리케이션의 나머지 부분을 호출하는 것과 동등합니다. 즉, 애플리케이션의 다른 부분(FilterSecurityInterceptor 또는 메소드 보안)에서 AuthenticationException이나 AccessDeniedException을 던지면 이곳에서 잡혀 처리됩니다. 이러한 예외는 ExceptionTranslationFilter에서 적절한 HTTP 응답으로 변환되어 처리됩니다.
#2 만약 사용자가 인증되지 않았거나 AuthenticationException이 발생했다면, 인증 과정을 시작합니다. 이것은 사용자가 현재 로그인되지 않았거나 로그인이 실패한 경우에 해당합니다. 사용자의 인증 상태를 확인하고 필요한 인증 작업을 수행하기 위해 이 단계에서 시작됩니다. 이것은 Spring Security에서 사용자의 인증을 수행하기 위한 과정을 시작하는 것을 의미합니다.
#3 그렇지 않다면 "Access Denied"가 발생했다는 의미입니다. 사용자의 인증은 성공했지만 해당 리소스 또는 작업에 대한 권한이 없을 경우에 이 단계에서 처리됩니다. 이러한 경우에는 AccessDeniedHandler를 호출하여 액세스 거부에 대한 처리를 합니다. 이 핸들러는 사용자가 요청한 작업에 대한 충분한 권한이 없을 때 호출되어 적절한 응답을 생성하고 사용자에게 적절한 오류 메시지를 제공합니다.

```
"Handling Security Exceptions"에서 설명한 대로, 인증되지 않은 상태로 인증이 필요한 리소스에 대한 요청이 올 때, 
인증이 성공한 후 해당 리소스를 다시 요청할 필요가 있습니다. 
Spring Security에서는 이를 달성하기 위해 HttpServletRequest를 RequestCache 구현을 사용하여 저장합니다.

RequestCache는 요청과 관련된 저장된 정보를 유지하고, 
인증이 성공한 후에 이 정보를 사용하여 원래 요청을 다시 생성할 수 있게 해줍니다. 
이것은 사용자가 로그인 페이지로 리디렉션되어 인증을 마치면, 
원래의 요청이 유지되어 그에 맞는 페이지로 이동할 수 있게 하는 데 도움이 됩니다. 
이러한 방식으로 사용자는 인증을 마치면 요청하려던 리소스로 자동으로 리디렉션됩니다.

```