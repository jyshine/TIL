package xunit;

public class XUnitTest {
    public static void main(String[] args) {
        new TestCaseTest("testRunning").run();
        new TestCaseTest("testSetUp").run();
    }
}


