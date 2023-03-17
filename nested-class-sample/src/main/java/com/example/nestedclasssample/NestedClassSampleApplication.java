package com.example.nestedclasssample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;


/**
 *
 * Nested Class 언제든 외부 Class로 만들 수 있다.
 * outer Class 와 의미적으로 깊이 관여가 있는 경우
 * outer class의 멤버 변수 사용 불가능
 *
 * 가독성이 좋아진다.
 * Static Class 를 private 를 만들기도 한다.
 * 내부에서만 사용하기 위해 사용.
 *
 * Class 파일 새로 만들기 번거로울 때 사용.
 *
 *
 * 반면, inner class는
 * 외부 클래스의 인스턴스 즉 Object가 먼저 존재해야하고
 * 그 Object와 직접적으로 연관관계가 있는 경우 사용한다.
 *
 * outer class의 멤버 변수 사용 가능
 *
 * 즉 inner class는 bean이 될 수 없다.
 * outer class가 bean으로 등록되어 있으면 @Component를 이용해서 등록은 가능하지만 불필요
 *
 */
@SpringBootApplication
public class NestedClassSampleApplication {
    private String name;

    // Static Nested Class
    @Component
    static class StaticInnerClass {
        public StaticInnerClass(){

            // LocalClass
            class LocalClass{
                public LocalClass() {
                    System.out.println("LocalClass");
                }
            }

            // Annoymous Class 익명 클래스
            var runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println("Runnable");
                }
            };

            System.out.println("StaticInnerClass");
        }
    }

    // (Non-Static Nested) Inner Class
    @Component
    class InnerClass {
        public InnerClass() {
            System.out.println("InnerClass");
        }
        void print() {
            System.out.println(name);
        }
    }
    public static void main(String[] args) {

        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(NestedClassSampleApplication.class, args);
        System.out.println(configurableApplicationContext.getBean(StaticInnerClass.class));
        System.out.println(configurableApplicationContext.getBean(InnerClass.class));

        new StaticInnerClass();
//        new InnerClass();// 오류
        NestedClassSampleApplication outerClass = new NestedClassSampleApplication();
        InnerClass innerClass = outerClass.new InnerClass();

    }

}
