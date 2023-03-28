package xunit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestCase {
    protected final String name;

    public TestCase(String name) {
        this.name = name;
    }

    public void run() {
//        testMethod();
//        너무 작게 쪼갤 필요 없다.
//        이름을 가지고 메소드 실행.

        try {
            Method method = getClass().getMethod(this.name);
            method.invoke(this);

        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }

    }
}
