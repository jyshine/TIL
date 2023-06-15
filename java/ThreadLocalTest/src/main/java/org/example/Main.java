package org.example;

public class Main {
    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            threadLocal.set("Data for Thread 1");
            System.out.println("Thread 1: " + threadLocal.get());

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            // 작업이 끝난 후 ThreadLocal 값 제거
            threadLocal.remove();
        });

        Thread thread2 = new Thread(() -> {
            threadLocal.set("Data for Thread 2");
            System.out.println("Thread 2: " + threadLocal.get());

            // 작업이 끝난 후 ThreadLocal 값 제거
            threadLocal.remove();
        });

        thread1.start();
        thread2.start();

        threadLocal.set("Data for Main Thread");
        System.out.println("Main Thread: " + threadLocal.get());

        // 작업이 끝난 후 ThreadLocal 값 제거
        threadLocal.remove();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}