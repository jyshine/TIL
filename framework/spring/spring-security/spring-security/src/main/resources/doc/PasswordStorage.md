
# Password Storage

Spring Security의 PasswordEncoder 인터페이스는 비밀번호를 안전하게 저장할 수 있도록 비밀번호의 일방향 변환을 수행하기 위해 사용됩니다. 
PasswordEncoder는 일방향 변환인데, 이것은 비밀번호 변환이 양방향이 필요한 경우(예: 데이터베이스 인증에 사용되는 자격 증명을 저장할 때)에는 유용하지 않습니다. 

일반적으로 PasswordEncoder는 인증 시에 사용자가 제공한 비밀번호와 비교해야 하는 비밀번호를 저장하기 위해 사용됩니다. 

# 비밀번호 저장 흐름
    1. plaintext : attacks such as SQL Injection, get large “data dumps” of usernames and passwords
    2. a one way hash, such as SHA-256 :  modern hardware we can perform billions of hash calculations a second
    3. adaptive one-way functions (bcrypt, PBKDF2, scrypt, argon2) : degrade the performance of an application
    4. Users are encouraged to exchange the long term credentials (that is, username and password) for a short term credential (such as a session, and OAuth Token, and so on).


# Rainbow Table
비밀번호 해시를 빠르게 역으로 해독하기 위해 미리 계산된 테이블입니다. 
이것은 주로 비밀번호 해시를 해독하기 위한 공격에 사용됩니다.

# DelegatingPasswordEncoder
Spring Security 5.0 이후부터
    - 현재 비밀번호 저장 권장 사항을 준수하여 비밀번호를 인코딩하는 것을 보장합니다.
    - 현대 및 레거시 형식으로 비밀번호를 검증할 수 있도록 합니다.
    - 미래에 인코딩을 업그레이드할 수 있도록 합니다.
DelegatingPasswordEncoder의 인스턴스는 PasswordEncoderFactories를 사용하여 쉽게 구성

# Password Storage Format
비밀번호 저장 형식이 공개되어 있다고 해도, 
비밀번호를 해독하려면 원래 비밀번호를 알아야 하므로 이러한 저장 형식만으로는 해커가 비밀번호를 얻는 것이 불가능합니다. 
따라서 비밀번호의 보안은 알고리즘 자체의 비밀성이 아니라 강력한 해싱 알고리즘과 적절한 솔트(Salt) 사용 등과 같은 기술적인 요소에 의존합니다. 
해시된 비밀번호와 솔트를 함께 사용하면 비밀번호 보안을 크게 강화할 수 있습니다.

# Password Encoding
DelegatingPasswordEncoder Encode Example

{bcrypt}$2a$10$dXJ3SW6G7P50lGmMkkmwe.20cQQubK3.HZWzG3YB1tlRy.fqvM/BG

# Trableshooting
이를 해결하는 가장 쉬운 방법은 현재 비밀번호가 어떻게 저장되어 있는지 파악하고 올바른 PasswordEncoder를 명시적으로 제공하는 것입니다.
Spring Security 4.2.x에서 마이그레이션하는 경우 NoOpPasswordEncoder 빈을 노출시켜 이전 동작으로 복원할 수 있습니다.
또 다른 방법은 모든 비밀번호를 올바른 id로 접두사를 붙이고 DelegatingPasswordEncoder를 계속 사용하는 것입니다. 

예를 들어, BCrypt를 사용하고 있다면 비밀번호를 다음과 같이 마이그레이션할 수 있습니다.
$2a$10$dXJ3SW6G7P50lGmMkkmwe.20cQQubK3.HZWzG3YB1tlRy.fqvM/BG
to
{bcrypt}$2a$10$dXJ3SW6G7P50lGmMkkmwe.20cQQubK3.HZWzG3YB1tlRy.fqvM/BG


# Test Code
[Encoder](https://github.com/jyshine/TIL/blob/main/framework/spring/spring-security/spring-security/src/test/java/com/example/springsecurity/password/EncoderTest.java)

[PasswordMatching](https://github.com/jyshine/TIL/blob/main/framework/spring/spring-security/spring-security/src/test/java/com/example/springsecurity/password/PasswordMatchingTest.java)

[PasswordStorage](https://github.com/jyshine/TIL/blob/main/framework/spring/spring-security/spring-security/src/test/java/com/example/springsecurity/password/PasswordStorageTest.java)
