# What is a CSRF Attack?
    Cross-Site Request Forgery는 어떠한 사용자의 권한으로 작업을 수행하도록 요청을 위조하는 공격.

# Protecting Against CSRF
    CSRF 공격이 가능한 이유는 희생자 웹 사이트에서의 HTTP 요청과 공격자 웹 사이트에서의 요청이 정확히 동일하기 때문입니다. 
    이것은 악의적인 웹 사이트에서 온 요청을 거부하고 은행 웹 사이트에서 온 요청만 허용하는 방법이 없음을 의미합니다. 
    CSRF 공격으로부터 보호하려면 요청에 악의적인 사이트가 제공할 수 없는 무언가가 있어야 하므로 두 요청을 구별할 수 있어야 합니다.

## Safe Methods Must be Idempotent
    Idempotent : 연산을 여러 번 적용하더라도 결과가 달라지지 않는 성질, 연산을 여러 번 반복하여도 한 번만 수행된 것과 같은 성질
    HTTP 프로토콜에서 사용되는 메서드 중 GET, HEAD, OPTIONS, TRACE와 같이 데이터를 변경하지 않고 정보를 요청하기만 하는 메서드 사용

## Synchronizer Token Pattern
    HTTP 요청이 제출되면 서버는 예상되는 CSRF 토큰을 찾아 실제 HTTP 요청에 있는 CSRF 토큰과 비교한다.
    값이 일치하지 않으면 HTTP 요청은 거부.
    HTTP GET에서 무작위 토큰을 포함시키지 않도록 한다.

## SameSite Attribute
    CSRF 공격에 대비하는 새로운 방법 중 하나는 쿠키에 SameSite 속성을 지정하는 것입니다. 
    서버는 쿠키를 설정할 때 SameSite 속성을 지정하여 외부 사이트에서 온 경우 해당 쿠키를 보내지 않아야 함을 나타낼 수 있습니다.
    Spring Security는 세션 쿠키의 생성을 직접 제어하지 않으므로 SameSite 속성을 지원하지 않습니다.
    Spring Session은 서블릿 기반 응용 프로그램에서 SameSite 속성을 지원합니다. 
    Spring Framework의 CookieWebSessionIdResolver는 WebFlux 기반 응용 프로그램에서 SameSite 속성을 기본 지원합니다.
    
    """
    SameSite HTTP response
    Set-Cookie: JSESSIONID=randomid; Domain=bank.example.com; Secure; HttpOnly; SameSite=Lax
    """
    
    Strict: 지정된 경우, 동일한 사이트에서 오는 모든 요청에 쿠키가 포함됩니다. 그렇지 않으면 쿠키가 HTTP 요청에 포함되지 않습니다.
    Lax: 지정된 경우, 동일한 사이트에서 오는 요청 또는 요청이 최상위 탐색에서 오고 메서드가 idempotent인 경우에만 쿠키가 전송됩니다. 그렇지 않으면 쿠키가 HTTP 요청에 포함되지 않습니다.
    Strict 사용하는 것은 예를 들어 메일로 인증할 때 쿠키가 전송되지 않아 사용자의 불편함을 줄 수 있다.


## When to use CSRF protection
    응용 프로그램이 Content-Type 헤더를 유효성 검사하지 않는 경우 이 공격에 노출될 수 있습니다. 
    Content-Type을 유효성 검사하는 Spring MVC 응용 프로그램은 URL 접미사를 .json으로 끝내는 것으로 업데이트하여 여전히 공격당할 수 있습니다.
    
    CSRF with JSON Spring MVC form
    """
    <form action="https://bank.example.com/transfer.json" method="post" enctype="text/plain">
        <input name='{"amount":100,"routingNumber":"evilsRoutingNumber","account":"evilsAccountNumber", "ignore_me":"' value='test"}' type='hidden'>
        <input type="submit" value="Win Money!"/>
    </form>
    """

    CSRF with JSON request
    """
    { "amount": 100,
    "routingNumber": "evilsRoutingNumber",
    "account": "evilsAccountNumber",
    "ignore_me": "=test"
    }
    """

## CSRF Considerations
    1. Logging In
    2. Logging Out
        
    3. CSRF and Session Timeouts
        1) JavaScript 요청을 통한 갱신
        2) JavaScript 만료 알려주고 사용자가 재갱신 클릭
        3)  CSRF 토큰을 쿠키에 저장, CSRF 토큰이 세션을 초과하여 유지
    4. Multipart(file upload)
        1) Avoid Reading the Body: 이 경우, CSRF 토큰을 body 읽지 않으며 대신 다른 방법으로 토큰을 포함하도록 요청을 구성해야 합니다. 이 방법은 좀 더 복잡할 수 있으며, 일부 상황에서 적용하기 어려울 수 있습니다.
        2) Prevent External Uploads: 이 방법은 업로드된 파일을 처리하기 전에 요청을 검사하여 외부 사이트에서의 업로드를 방지하는 것입니다. Spring Security와 같은 보안 라이브러리를 사용하면 이러한 검사를 수행할 수 있습니다. 이 방법은 CSRF 공격을 방지하면서도 파일 업로드를 지원합니다.
    
## About Session Timeouts 
    세션 유지: 세션이 만료되지 않도록 사용자의 활동을 추적하고 세션을 지속적으로 유지합니다. 이렇게 하면 사용자 경험에 큰 영향을 미치지만, CSRF 공격으로부터 보호됩니다.
    세션 자동 갱신: 세션이 만료되지 않는 한 자동으로 갱신되도록 설정합니다. 이를 통해 사용자는 계속해서 활동하지 않아도 됩니다. 다만 이로 인해 서버 리소스 부하가 증가할 수 있습니다.
    세션 확장: 세션 만료 시간을 연장하거나 지속적으로 갱신할 수 있는 정책을 설정합니다. 이렇게 하면 사용자가 활동하지 않아도 세션이 계속 유지됩니다.
    단계적인 인증: 시간 초과 문제를 해결하기 위해 단계적으로 사용자를 인증하고 특정 작업에 대한 인증을 요구합니다. 이 방식은 더 많은 보안을 제공할 수 있지만 사용자 경험에 영향을 미칠 수 있습니다.
    보다 긴 세션 시간 초과: 세션의 만료 시간을 더 길게 설정합니다. 이 경우에는 더 긴 시간 동안 사용자가 활동하지 않아도 됩니다. 다만 이로 인해 보안이 감소할 수 있습니다.
    Remember Me 기능: 사용자가 로그인 정보를 기억하도록 하여 세션 만료 시간에 민감하지 않도록 합니다. 이 방식은 일반적으로 "Remember Me" 기능으로 구현되며, 사용자가 재인증 없이 오랜 시간 동안 로그인 상태를 유지할 수 있습니다.


    