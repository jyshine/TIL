package xunit;

public class TestCaseTest extends TestCase {

    WasRun wasRun;
    @Override
    public void setUp() {
        this.wasRun = new WasRun("testMethod");

    }

    public TestCaseTest(String name) {
        super(name);
    }

    public void testRunning() {
        //라이브러리에서는 assert를 사용
        Assert.assertEquals(false, wasRun.wasRun);
//        wasRun.testMethod();
        wasRun.run();
        Assert.assertEquals("setUp testMethod", wasRun.log);
        Assert.assertEquals(true, wasRun.wasRun);
    }

    public void testSetUp() {
        //라이브러리에서는 assert를 사용
        Assert.assertEquals(false, wasRun.wasSetUp);
        wasRun.run();
        Assert.assertEquals("setUp testMethod", wasRun.log);
        Assert.assertEquals(true, wasRun.wasSetUp);
    }

}
