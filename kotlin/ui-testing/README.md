# 테스트는 어떻게 해야할까?

# Why?
* 잦은 오류는 서비스의 신뢰를 떨어트리고 제품의 가치 평가를 절하한다.

# So what?
* 서비스 기능 개발 단계에서 잘 구현이 되었는지 확인하고 싶다.
* 개발 환경과 운영환경에서 테스트 하고 싶다.
* 테스트를 자동화 하고 싶다.
* 오류 발생 시 원인을 빠르게 파악하고 재현해 정확하게 해결하고 싶다.

# Testing approach
* Static, dynamic, passive testing
* Exploratory approach
* The “box” approach
-White-box testing
-Black-box testing
-Component interface testing
-Visual testting
-Grey-box testing


# Black-box test
내부 구조나 작동 방식을 들여다 보지 않고 응용 프로그램의 기능을 검사하는 소프트웨어 테스트 방법
# White-box test
시스템의 내부 구조 또는 작동을 테스트하는 소프트웨어 테스트 방법

# Black-box testing과 White-box testing 차이?
```
화이트박스 테스팅과 블랙박스 테스팅은 소프트웨어 테스팅의 두 가지 기본 접근 방식입니다.
블랙박스 테스팅은 소프트웨어 시스템을 "블랙박스"로 다루며, 
소프트웨어의 내부 구조를 살펴보지 않고 기능을 테스트하는 것에 중점을 둡니다. 

테스터들은 내부 코드 구조에 대한 지식 없이 입력 및 출력 요구 사항을 기반으로 테스트 케이스를 설계합니다. 
블랙박스 테스팅의 목적은 사용자의 관점에서 시스템의 기능을 검증하는 것입니다.
반면 화이트박스 테스팅은 소프트웨어의 내부 구조, 즉 코드, 설계 및 아키텍처를 테스트하는 방법입니다. 
테스터들은 시스템의 내부 작업에 대한 지식을 활용하여 개별 구성 요소를 테스트하고 올바르게 작동하는지 
확인하는 테스트 케이스를 설계합니다. 

화이트박스 테스팅의 목적은 코드의 정확성과 품질을 검증하고 블랙박스 테스팅에서는 분명하지 않을 수 있는 
결함과 취약점을 식별하는 것입니다.

요약하면, 화이트박스 테스팅과 블랙박스 테스팅의 주요 차이점은 
화이트박스 테스팅이 소프트웨어의 내부 작업을 테스트하는 데 중점을 둔 것이고, 
블랙박스 테스팅은 소프트웨어의 외부 동작을 테스트하는 데 중점을 둔 것입니다.

```

화이트박스 테스팅에서 코드 커버리지(code coverage)는 소프트웨어의 테스트 케이스가 얼마나 많은 코드를 실행하고 테스트했는지를 나타내는 지표입니다.
코드 커버리지는 소프트웨어 개발자가 테스트 케이스가 충분한지, 어떤 부분에서 추가 테스트가 필요한지, 그리고 코드의 품질을 어떻게 개선할 수 있는지를 판단하는 데 도움이 됩니다. 일반적으로 코드 커버리지는 백분율로 표시되며, 테스트된 코드 라인 수와 전체 코드 라인 수의 비율로 계산됩니다.
코드 커버리지를 높이는 것은 소프트웨어의 품질을 높이는 데 중요합니다. 
그러나 **코드 커버리지가 100%라고 해서 모든 결함이 발견되는 것은 아닙니다. 따라서 코드 커버리지는 소프트웨어의 테스트 케이스에 대한 일부 정보를 제공하지만, 결함이나 취약점을 발견하기 위해서는 다른 테스트 기법들과 함께 사용해야 합니다.**

# Code Coverage란?
Code coverage는 소프트웨어 테스트에서 사용되는 측정 지표 중 하나입니다. 코드 커버리지는 소프트웨어 코드가 테스트 케이스에 의해 실행된 비율을 나타냅니다. 즉, 코드 커버리지는 **test suite** 가 실행된 후에 코드베이스의 얼마나 많은 부분이 실행 되었는지를 나타냅니다.

# Code coverage tools?
* **JaCoCo**: JaCoCo는 자바 코드를 위한 오픈 소스 코드 커버리지 도구입니다. Java 가상 머신 상에서 작동하며, 테스트를 실행하면 코드 커버리지 보고서를 생성합니다.
* **Cobertura**: Cobertura는 Java 코드를 위한 무료 코드 커버리지 도구입니다. Java 가상 머신 상에서 작동하며, 테스트를 실행하면 코드 커버리지 보고서를 생성합니다.
* **Istanbul**: Istanbul은 JavaScript 코드를 위한 오픈 소스 코드 커버리지 도구입니다. Node.js 런타임 환경에서 작동하며, 테스트를 실행하면 코드 커버리지 보고서를 생성합니다.
* **Clover**: Clover는 Java 및 Groovy 코드를 위한 상용 코드 커버리지 도구입니다. Java 가상 머신 상에서 작동하며, 테스트를 실행하면 코드 커버리지 보고서를 생성합니다.
* **Coveralls**: Coveralls는 다양한 언어를 지원하는 오픈 소스 코드 커버리지 도구입니다. GitHub과 연동하여 테스트 결과를 수집하고, 코드 커버리지 보고서를 생성합니다.

# JaCoCo Code Converage 측정 지표
* Instruction Coverage
코드에서 실행된 명령어 수와 전체 명령어 수의 비율
* Branch Coverage
코드에서 실행된 조건문의 수와 전체 조건문 수의 비율
* Line Coverage
코드에서 실행된 라인 수와 전체 라인 수의 비율
* Method Coverage
코드에서 실행된 메서드 수와 전체 메서드의 수의 비율
* Class Coverage
코드에서 실행된 전체 클래수 수와 전체 클래스 수의 비율
* Complexity Coverage
코드에서 실행된 복잡한 부분의 비율

# JaCoCo Getting Started (gradle)
**1.build.gradle plugin 추가**
```
plugins {
  id 'java'
  id 'jacoco'
}

```
**2.JaCoCo 설정**
```
jacoco {
    toolVersion = "0.8.7"
}

```
**3.테스트 실행 후 보고서 생성 설정**
```
test {
    finalizedBy jacocoTestReport // 테스트 실행 후 report 생성
}

jacocoTestReport {
    reports {
        xml.enabled true // xml report 생성 여부
        html.enabled true // html report 생성 여부
    }
    dependsOn test // test 실행 후 report 생성
}

```
위 코드에서 test 태스크는 테스트를 실행하는 태스크입니다. finalizedBy를 사용하여 test 태스크가 끝난 후에 jacocoTestReport 태스크가 실행되도록 설정합니다. jacocoTestReport 태스크는 JaCoCo 보고서를 생성하는 태스크입니다. reports 블록에서 보고서의 형식을 설정할 수 있으며, dependsOn을 사용하여 jacocoTestReport 태스크가 test 태스크에 의존하도록 설정합니다.


**4.보고서 확인**
```
build/reports/jacoco/test/html/index.html
build/reports/jacoco/test/xml/jacocoTestReport.xml

```


# Black-box testing 직접 해보기
* JDK 11
* Kotlin 1.8.0
* Selenium 4.8.1
* Allure 2.9.6

* CI/CD 테스트 자동화를 위해 kotlin + Selenium 을 선택.
* 프로젝트 빌드 스크립트에 테스트 프로젝트 실행 Command 추가하여 테스트 및 리포트 생성 가능 

**Kotlin 프로젝트로 Selenium 이용해 UI Test 자동화 하기**
* [테스트 영상 (위탁상품 조회 후 상품 상세 확인)](https://github.com/jyshine/TIL/blob/main/kotlin/ui-testing/doc/%ED%99%94%EB%A9%B4%20%EA%B8%B0%EB%A1%9D%202023-04-20%20%EC%98%A4%EC%A0%84%208.20.06.mov)

```
└── src
├── main
└── test
├── kotlin
│   └── ui
│   ├── TestMain.kt → 테스트 실행
│   ├── common
│   │   ├── ScreenshotOnError.kt → 오류 발생시 스크린샷 
│   │   ├── TestInfo.kt → 테스트에 필요한 정보 (보안을 위해 추후 환경변수로 빼기)
│   │   └── XpathInfo.kt → 테스트 UI xpath 정보
│   └── eum
│   └── ActionEnum.kt → Selenium 이벤트
└── resources
└── chromedriver → chrome driver

```


```
class TestInfo {

    companion object{
        var CHROME_DRIVER_PATH = "${System.getProperty("user.dir")}/src/test/resources/chromedriver"
        const val WEBDRIVER_HTTP_FACTORY = "jdk-http-client"
        const val TEST_URL = ""
        const val LOGIN_ID = ""
        const val PASSWORD = ""
        const val SEARCH_KEYWORD = "가방"

    }
}

```


```
class XpathInfo {
    companion object {
        // 로그인 페이지 이동
        const val NAVIGATE_LOGIN_PAGE = "//*[@id='app']/div/div[1]/div/ul/li[1]/button"
        // 로그인 id 입력
        const val INPUT_LOGIN_ID = "//div[@id='app']/div/div[2]/div[2]/div/div/div/div/input"
        // 로그인 password 입력
        const val INPUT_LOGIN_PASSWORD = "//div[@id='app']/div/div[2]/div[2]/div/div/div[2]/div/input"
        // 로그인 버튼 클릭
        const val CLICK_LOGIN_BUTTION = "//div[@id='app']/div/div[2]/div[2]/div/div[3]"
        // 공지사항 확인 및 닫기
        const val CLICK_NOTICE_MODAL = "//div[@id='app']/div/div[2]/div[5]/div/div[2]/div/div/button/i"
        // 위탁 관리
        const val NAVIGATE_CONSIGNMENT = "//div[@id='app']/div/div/div/div[2]/div/div[5]/a/span"
        // 위탁 상품 가져오기
        const val NAVIGATE_CONSIGNMENT_SEARCH = "//div[@id='app']/div/div/div/div[2]/div/div[5]/div/div/div/a/span"
        // 도매매 클릭
        const val CLICK_CONSIGNMENT_SEARCH_DOMEME = "//div[@id='app']/div/div[2]/div[2]/div/div[1]/div[2]/div[1]/span"
        // 오너클랜 클릭
        const val CLICK_CONSIGNMENT_SEARCH_OWNERCLAN = "/html/body/div/div/div[2]/div[2]/div/div[1]/div[2]/div[2]/span"
        // 검색 조건 선택
        const val CLICK_CONSIGNMENT_SEARCH_TYPE = "//div[@id='app']/div/div[2]/div[2]/div/div[2]/div[2]/div/div[1]"
        // 상품명 클릭
        const val CLICK_CONSIGNMENT_SEARCH_TYPE_PRODUCT_NAME = "//div[@id='app']/div/div[2]/div[2]/div/div[2]/div[2]/div/div[2]/div[3]/p"
        // 검색어 입력
        const val INPUT_CONSIGNMENT_SEARCH_PRODUCT_NAME = "//div[@id='app']/div/div[2]/div[2]/div/div[2]/div[2]/input"
        // 검색 클릭
        const val CLICK_CONSIGNMENT_SEARCH_BUTTON= "//div[@id='app']/div/div[2]/div[3]/div[1]/p"
        // 검색 결과 total count
        const val GET_TEXT_CONSIGNMENT_SEARCH_RESULT_COUNT = "//div[@id='app']/div/div[2]/div[5]/div[1]/h4/em/span"
        // 위탁 상품 조회 펼치기
        const val CLICK_CONSIGNMENT_SEARCH_MORE_LIST_BOTTON = "/html/body/div/div/div[2]/div[5]/div[4]/div/p"
        // 위탁 상품 조회 리스트 상품명
        var ROW_CONSIGNMENT_SEARCH_LIST_PRODUCT_NAME = "/html/body/div/div/div[2]/div[5]/div[3]/div/div/div[1]/div[2]/div[3]/div[2]/div/div/div[#count#]/div[3]/div/span/div/p"
        // 위탁 상품 조회 리스트 상품번호
        var ROW_CONSIGNMENT_SEARCH_LIST_PRODUCT_NO = "/html/body/div/div/div[2]/div[5]/div[3]/div/div/div[1]/div[2]/div[3]/div[2]/div/div/div[#count#]/div[2]/div/span"
        // 위탁 상품 상세보기 닫기
        const val CLICK_CONSIGNMENT_SEARCH_DETAIL_CLOSE = "/html/body/div/div/div[2]/div[7]/div/div[2]/div/div[1]/button/i"
        // 위탁 상품 가져오기 조회 결과 전체 선택
        const val CLICK_ALL_CHECKBOX_CONSIGNMENT_SEARCH_RESULT = "/html/body/div/div/div[2]/div[5]/div[3]/div/div/div[1]/div[2]/div[1]/div[1]/div/div/div[2]/div[2]/input"
        // 위탁 상품 가져오기 수량제한 모달 확인
        const val CLICK_OK_CONSIGNMENT_SEARCH_IMPORT = "/html/body/div/div[2]/div/div[2]/div/div[3]/div/div/button"
        // 위탁 상품 가져오기 상품 수집 버튼 클릭
        const val CLICK_CONSIGNMENT_IMPORT_BUTTON = "/html/body/div/div/div[2]/div[4]/div[2]/div/div[1]/p"
        // 위탁 상품 가져오기 상품 수집 확인 버튼 클릭
        const val CLICK_OK_CONSIGNMENT_IMPORT_BUTTON = "/html/body/div/div[2]/div/div[2]/div/div[3]/div/button[2]"
        // 위탁 상품 수집 결과 확인
        const val GET_TEXT_CONSIGNMENT_IMPORT_RESULT = "/html/body/div/div[2]/div/div[2]/div/div[2]/p"
        // 위탁 상품 수집 결과 확인 버튼 클릭
        const val CLICK_OK_CONSIGNMENT_IMPORT_RESULT_BUTTON = "/html/body/div/div[2]/div/div[2]/div/div[3]/div/button"

        // 위탁관리 > 위탁 기초 상품
        const val NAVIGATE_CONSIGNMENT_BASIC_PRODUCT = "/html/body/div/div/div[1]/div/div[2]/div/div[5]/div/div/div[2]/a/span"
        // 기초상품 상품 목록 수
        const val GET_TEXT_CONSIGNMENT_BASIC_PRODUCT_COUNT = "/html/body/div/div/div[2]/div/div[4]/div[1]/div[1]/div/h4/span"
        // 상단 탭 전체(옵션별)
        const val CLICK_CONSIGNMENT_BASIC_PRODUCT_SEARCH_OPTION = "/html/body/div/div/div[2]/div/div[1]/div/div/div[2]/div"
        // 상단 탭 변경상품
        const val CLICK_CONSIGNMENT_BASIC_PRODUCT_SEARCH_CHANGED = "/html/body/div/div/div[2]/div/div[1]/div/div/div[3]/div"
        // 전체(위탁기초)
        const val CLICK_CONSIGNMENT_BASIC_PRODUCT_SEARCH_ALL= "/html/body/div/div/div[2]/div/div[1]/div/div/div[1]/div"
    }
}

```

```
enum class ActionEnum {
    CLICK,
    INPUT,
    GET_TEXT,
    IS_NOT_EMPTY_CLICK,
    SIZE_FOUND_ELEMENT,
    IS_NOT_EMPTY_GET_TEXT

}

```



**Test Code 작성 방법**
1 Test Method 생성
2 Test 정보 annotion 추가
3 테스트 시나리오 작성
4 findElementAndAction 이용해 이벤트 생성
findElementAndAction() 기능 ChromeDriver를 사용하여 xPath를 통해 웹 페이지의 요소를 찾고, 해당 요소에 대한 작업을 수행합니다.

함수는 다음과 같은 매개 변수를 사용합니다:
	* chromedriver: ChromeDriver 객체
	* xPath: 요소를 찾기 위한 XPath 표현식
	* name: 함수의 이름
	* action: ActionEnum 타입의 enum 값으로, 요소에 대한 수행 작업을 지정합니다.
	* inputText: ActionEnum.INPUT 작업을 수행할 때 입력할 텍스트 (기본값은 null)
	* afterSleepTime: 함수 실행 후 대기할 시간 (기본값은 1000ms)
	* beforeSleepTime: 함수 실행 전 대기할 시간 (기본값은 1000ms)

함수는 요소에 대한 작업을 수행하고, 결과값을 반환합니다. 반환값은 ActionEnum 값에 따라 다르게 됩니다. 만약 작업이 실패하면, 해당 요소가 존재하지 않으면 null을 반환합니다. 함수는 일부 작업을 수행하기 전과 후에 대기할 시간을 제공하여 요소를 처리하는 과정에서 예기치 않은 오류를 방지할 수 있습니다.

**Chrome 실행화면 보기 또는 백그라운드로 실행**
```
    // 백그라운드로 실행
  private val driver = ChromeDriver(ChromeOptions()
        .addArguments("--headless")
        .addArguments("--disable-mobile-emulation")
        .addArguments("--window-size=1920,1080")
    )

    // UI 확인
    // private val driver = ChromeDriver()

```


**결과 화면**
```
$프로젝트 ./gradlew allureServe    
```
* https://github.com/jyshine/TIL/blob/main/kotlin/ui-testing/doc/1.png
* https://github.com/jyshine/TIL/blob/main/kotlin/ui-testing/doc/2.png
* https://github.com/jyshine/TIL/blob/main/kotlin/ui-testing/doc/3.png


**개선할 점**
* 테스트 정보 설정 파일로 보안 처리.
* 개발 시 테스트 코드 생성 및 관리가 중요.
* 테스트 시나리오를 엑셀파일과 같은 파일을 가져와서 테스트할 수 있도록 개선 필요. 
* 필요 시 배포할 때 실행하도록 처리.

**한계점**
* 테스트 케이스 생성 단순 반복 작업.
* 지속적인 관리 필요.
* Code Coverage 결과로 코드의 복잡도를 상세하게 확인하기 어려움.
* 기존 생성된 서비스의 경우 테스트 코드 작성이 복잡함.
* Selenium Element 찾을 때 Xpath로 찾게 되어 구조 변경 시 다시 설정해줘야함.
