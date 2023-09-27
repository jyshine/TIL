# Security HTTP Response Headers
    - Spring Security를 구성하여 사용자 정의 헤더를 제공
    - 웹 애플리케이션의 보안을 높이기 위해 HTTP 응답 헤더를 다양하게 활용

# Default Security Headers
   
    Cache-Control: no-cache, no-store, max-age=0, must-revalidate
    Pragma: no-cache
    Expires: 0
    X-Content-Type-Options: nosniff
    Strict-Transport-Security: max-age=31536000 ; includeSubDomains
    X-Frame-Options: DENY
    X-XSS-Protection: 0

    Strict-Transport-Security 는 HTTPS 요청에서만 추가 가능.

# Cache Control
    Spring Security의 기본 설정은 사용자의 콘텐츠를 보호하기 위해 캐싱을 비활성화하는 것!
    애플리케이션이 자체적으로 캐시 제어 헤더를 제공한다면, Spring Security는 이를 무시합니다.
    
# Content Type Options
    Spring Security는 기본적으로 콘텐츠 스니핑을 비활성화하고 HTTP 응답에 다음 헤더를 추가하여 이 문제를 해결합니다.
    
    콘텐츠 스니핑(Content Sniffing)은 웹 브라우저나 다른 클라이언트가 서버로부터 전송된 콘텐츠의 형식(content type)을 자동으로 감지하거나 추측하는 기술

# HTTP Strict Transport Security (HSTS)
    Man-in-the-Middle 공격이 발생할 가능성을 크게 줄이기 위해 HTTPS 사용
    사이트가 HSTS 호스트로 표시되는 방법 중 하나는 해당 호스트를 브라우저에 사전로드(preload)하는 것입니다. 
    다른 방법은 응답에 Strict-Transport-Security 헤더를 추가하는 것입니다. 
    예를 들어, Spring Security의 기본 동작은 다음 헤더를 추가하여 브라우저에게 해당 도메인을 1년 동안(윤년 기준 31536000초) 
    HSTS 호스트로 취급하도록 지시
    
    Man-in-the-Middle (MitM) 공격은 공격자가 통신 경로 중간에 위치하여 통신 상대방 간의 메시지를 도청, 조작 또는 캡처하는 공격 형태입니다
# X-Frame-Options
    사이트가 프레임에 추가되는 것은 보안 문제가 될 수 있습니다. 
    예를 들어, 영리한 CSS 스타일링을 사용하면 사용자들을 의도하지 않은 클릭으로 속일 수 있습니다. 
    예를 들어, 은행에 로그인한 사용자가 다른 사용자에게 액세스 권한을 부여하는 버튼을 클릭할 수 있습니다. 
    이러한 유형의 공격은 Clickjacking으로 알려져 있습니다.
    해결하는 더 현대적인 접근 방식은 X-Frame-Options 헤더를 사용하는 것입니다. 
    Spring Security는 기본적으로 다음 헤더를 사용하여 iframe 내에서 페이지 렌더링을 비활성화합니다.
    X-Frame-Options: DENY
# X-XSS-Protection
    OWASP 권장 사항은 해당 헤더를 명시적으로 0으로 설정하는 것입니다.

# Custom Headers
    Spring Security는 일반적인 보안 헤더를 애플리케이션에 추가하기 편리하게 만드는 메커니즘을 제공합니다. 
    그러나 사용자 정의 헤더를 추가할 수 있도록 확장 포인트도 제공합니다.


# [자세한 내용](https://docs.spring.io/spring-security/reference/features/exploits/headers.html)