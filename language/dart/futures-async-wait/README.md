- Asynchronus <br>
 [ □ ] <br>
 [ □ | △ ] <br>
 [ △ | ○ ] <br>
 [ ○ ] <br>

- Synchronus <br>
 [ □ ]<br>
 [ □ ]<br>
 [ △ ]<br>
 [ △ ]<br>
 [ ○ ]<br>
 [ ○ ]<br>


- Future는 비동기 작업을 나타내는 Dart의 클래스입니다. 
- 비동기 작업은 일반적으로 시간이 오래 걸리는 작업이나 외부 리소스에 대한 액세스, 네트워크 요청 등을 포함합니다. 

- Future 객체는 작업이 완료되면 해당 결과를 제공하거나 오류를 보고하는 데 사용됩니다. 
- 비동기 작업이 실행되면 Future 객체를 반환하고, 작업이 완료되면 해당 Future 객체는 완료 상태가 됩니다. 
- 이후 Future 객체를 통해 비동기 작업의 결과를 얻거나 오류를 처리할 수 있습니다.

1. Future 생성: 
    비동기 작업을 나타내는 Future 객체를 생성합니다.
2. 비동기 작업 실행: 
    비동기 작업을 실행하고, Future 객체를 반환합니다.
3. Future 처리: 
    Future 객체를 통해 작업의 결과를 기다리거나, 작업이 완료되었을 때 결과나 오류를 처리합니다.

[test-code](https://github.com/jyshine/TIL/tree/main/dart/futures-async-wait/lib)