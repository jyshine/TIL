package xunit;

public class XUnitTest {
    public static void main(String[] args) {
        WasRun wasRun = new WasRun("testMethod");
        //라이브러리에서는 assert를 사용
        System.out.println(wasRun.wasRun);
        wasRun.testMethod();
        wasRun.run();
        System.out.println(wasRun.wasRun);
    }
}
