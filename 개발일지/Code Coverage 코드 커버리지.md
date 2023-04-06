# Code Coverage 코드 커버리지

## Code Coverage란?
 Code coverage는 소프트웨어 테스트에서 사용되는 측정 지표 중 하나입니다. 코드 커버리지는 소프트웨어 코드가 테스트 케이스에 의해 실행된 비율을 나타냅니다. 즉, 코드 커버리지는 **test suite** 가 실행된 후에 코드베이스의 얼마나 많은 부분이 실행 되었는지를 나타냅니다.
 

*test suite : “A collection of test cases” test case의 모음. 


## Testing approach
- Static, dynamic, passive testing
- Exploratory approach
- The “box” approach
	-White-box testing
	-Black-box testing
	-Component interface testing
	-Visual testting
	-Grey-box testing


## Black-box test
내부 구조나 작동 방식을 들여다 보지 않고 응용 프로그램의 기능을 검사하는 소프트웨어 테스트 방법


## White-box test
시스템의 내부 구조 또는 작동을 테스트하는 소프트웨어 테스트 방법.
	

## Black-box testing과 White-box testing 차이?
```
화이트박스 테스팅과 블랙박스 테스팅은 소프트웨어 테스팅의 두 가지 기본 접근 방식입니다.
블랙박스 테스팅은 소프트웨어 시스템을 "블랙박스"로 다루며, 소프트웨어의 내부 구조를 살펴보지 않고 기능을 테스트하는 것에 중점을 둡니다. 테스터들은 내부 코드 구조에 대한 지식 없이 입력 및 출력 요구 사항을 기반으로 테스트 케이스를 설계합니다. 블랙박스 테스팅의 목적은 사용자의 관점에서 시스템의 기능을 검증하는 것입니다.
반면 화이트박스 테스팅은 소프트웨어의 내부 구조, 즉 코드, 설계 및 아키텍처를 테스트하는 방법입니다. 테스터들은 시스템의 내부 작업에 대한 지식을 활용하여 개별 구성 요소를 테스트하고 올바르게 작동하는지 확인하는 테스트 케이스를 설계합니다. 화이트박스 테스팅의 목적은 코드의 정확성과 품질을 검증하고 블랙박스 테스팅에서는 분명하지 않을 수 있는 결함과 취약점을 식별하는 것입니다.
요약하면, 화이트박스 테스팅과 블랙박스 테스팅의 주요 차이점은 화이트박스 테스팅이 소프트웨어의 내부 작업을 테스트하는 데 중점을 둔 것이고, 블랙박스 테스팅은 소프트웨어의 외부 동작을 테스트하는 데 중점을 둔 것입니다.

```


화이트박스 테스팅에서 코드 커버리지(code coverage)는 소프트웨어의 테스트 케이스가 얼마나 많은 코드를 실행하고 테스트했는지를 나타내는 지표입니다.

코드 커버리지는 소프트웨어 개발자가 테스트 케이스가 충분한지, 어떤 부분에서 추가 테스트가 필요한지, 그리고 코드의 품질을 어떻게 개선할 수 있는지를 판단하는 데 도움이 됩니다. 일반적으로 코드 커버리지는 백분율로 표시되며, 테스트된 코드 라인 수와 전체 코드 라인 수의 비율로 계산됩니다.

코드 커버리지를 높이는 것은 소프트웨어의 품질을 높이는 데 중요합니다. 그러나 코드 커버리지가 100%라고 해서 모든 결함이 발견되는 것은 아닙니다. 따라서 코드 커버리지는 소프트웨어의 테스트 케이스에 대한 일부 정보를 제공하지만, 결함이나 취약점을 발견하기 위해서는 다른 테스트 기법들과 함께 사용해야 합니다.

## Code coverage tools?
- **JaCoCo**: JaCoCo는 자바 코드를 위한 오픈 소스 코드 커버리지 도구입니다. Java 가상 머신 상에서 작동하며, 테스트를 실행하면 코드 커버리지 보고서를 생성합니다.

- **Cobertura**: Cobertura는 Java 코드를 위한 무료 코드 커버리지 도구입니다. Java 가상 머신 상에서 작동하며, 테스트를 실행하면 코드 커버리지 보고서를 생성합니다.

- **Istanbul**: Istanbul은 JavaScript 코드를 위한 오픈 소스 코드 커버리지 도구입니다. Node.js 런타임 환경에서 작동하며, 테스트를 실행하면 코드 커버리지 보고서를 생성합니다.

- **Clover**: Clover는 Java 및 Groovy 코드를 위한 상용 코드 커버리지 도구입니다. Java 가상 머신 상에서 작동하며, 테스트를 실행하면 코드 커버리지 보고서를 생성합니다.

- **Coveralls**: Coveralls는 다양한 언어를 지원하는 오픈 소스 코드 커버리지 도구입니다. GitHub과 연동하여 테스트 결과를 수집하고, 코드 커버리지 보고서를 생성합니다.


## JaCoCo Code Converage 측정 지표
- Instruction Coverage
코드에서 실행된 명령어 수와 전체 명령어 수의 비율
- Branch Coverage
코드에서 실행된 조건문의 수와 전체 조건문 수의 비율
- Line Coverage
코드에서 실행된 라인 수와 전체 라인 수의 비율
- Method Coverage
코드에서 실행된 메서드 수와 전체 메서드의 수의 비율
- Class Coverage
코드에서 실행된 전체 클래수 수와 전체 클래스 수의 비율
- Complexity Coverage
코드에서 실행된 복잡한 부분의 비율

## JaCoCo Getting Started (gradle)
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


**5.보고서 확인 내용!**

HTML
- **Element**:이 열은 분석 대상인 코드 요소의 유형을 나타냅니다. 예를 들어 클래스나 메서드 등이 될 수 있습니다.
- **Missed Instructions**:이 열은 지정된 코드 요소의 테스트 중 실행되지 않은 코드 명령의 수를 나타냅니다.
- **Missed Branches**:이 열은 지정된 코드 요소에서 테스트 중 실행되지 않은 브랜치(조건 분기)의 수를 나타냅니다.
- **Missed**:이 열은 지정된 코드 요소에서 테스트 중 실행되지 않은 코드 라인의 수를 나타냅니다.
- **Cxty**:이 열은 지정된 코드 요소에서 테스트 중 실행되지 않은 복잡한 제어 흐름 경로(Complexity)의 수를 나타냅니다.
- **Missed Lines**:이 열은 지정된 코드 요소에서 테스트 중 실행되지 않은 코드 라인의 수를 나타냅니다.
- **Missed Methods**:이 열은 지정된 코드 요소에서 테스트 중 실행되지 않은 메서드의 수를 나타냅니다.
- **Missed Classes**:이 열은 지정된 코드 요소에서 테스트 중 실행되지 않은 클래스의 수를 나타냅니다.

CSV
- **Name**: 이 열은 분석 대상인 코드 요소의 이름을 보여줍니다. 예를 들어 클래스나 메서드의 이름이 될 수 있습니다.
- **Instructions Covered**: 이 열은 지정된 코드 요소에서 테스트 중 실행된 코드 명령의 수를 나타냅니다.
- **Instructions Missed**: 이 열은 지정된 코드 요소에서 테스트 중 실행되지 않은 코드 명령의 수를 나타냅니다.
- **Branches Covered**: 이 열은 지정된 코드 요소에서 테스트 중 실행된 브랜치(조건 분기)의 수를 나타냅니다.
- **Branches Missed**: 이 열은 지정된 코드 요소에서 테스트 중 실행되지 않은 브랜치(조건 분기)의 수를 나타냅니다.
- **Lines Covered**: 이 열은 지정된 코드 요소에서 테스트 중 실행된 코드 라인의 수를 나타냅니다.
- **Lines Missed**: 이 열은 지정된 코드 요소에서 테스트 중 실행되지 않은 코드 라인의 수를 나타냅니다.
- **Complexity Covered**: 이 열은 지정된 코드 요소에서 테스트 중 실행된 복잡한 제어 흐름 경로(Complexity)의 수를 나타냅니다.
- **Complexity Missed**: 이 열은 지정된 코드 요소에서 테스트 중 실행되지 않은 복잡한 제어 흐름 경로(Complexity)의 수를 나타냅니다.
- **Methods Covered**: 이 열은 지정된 코드 요소에서 테스트 중 실행된 메서드의 수를 나타냅니다.
- **Methods Missed**: 이 열은 지정된 코드 요소에서 테스트 중 실행되지 않은 메서드의 수를 나타냅니다.
- **Classes Covered**: 이 열은 지정된 코드 요소에서 테스트 중 실행된 클래스의 수를 나타냅니다.
- **Classes Missed**: 이 열은 지정된 코드 요소에서 테스트 중 실행되지 않은 클래스의 수를 나타냅니다.




#spring #test
