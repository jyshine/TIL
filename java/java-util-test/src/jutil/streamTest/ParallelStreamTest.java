package jutil.streamTest;


import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ParallelStreamTest {
    public static void main(String[] args) {
        AtomicInteger count = new AtomicInteger(0);
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        numbers.parallelStream()
                .map(number -> number * 2)
                .forEach(num -> {
                    System.out.println("sum result : " + num);
                    System.out.println("complete count : " +count.incrementAndGet());
                });
    }
}
