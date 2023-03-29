package xunit;

public class TestCaseTest extends TestCase {

    public TestCaseTest(String name) {
        super(name);
    }

    public void testRunning() {
        WasRun wasRun = new WasRun("testMethod");
        //라이브러리에서는 assert를 사용
        System.out.println(wasRun.wasRun);
        wasRun.testMethod();
        wasRun.run();
        System.out.println(wasRun.wasRun);
    }
}
