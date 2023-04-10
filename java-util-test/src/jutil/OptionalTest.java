package jutil;

import java.util.NoSuchElementException;
import java.util.Optional;
import javax.swing.text.html.Option;

public class OptionalTest {
    public static void main(String[] args) {
        Person person1 = new Person("tester", 1);
        Person person2 = null;

        // Optional of
        Optional<Person> optionalPerson1 = Optional.of(person1);
//        Optional<Person> optionalPerson2 = Optional.of(person2); // NullPointerException
        System.out.println("Optional.of: "+optionalPerson1);
//        System.out.println(optionalPerson2);

        // Optional ofNullable
        System.out.println("ofNullable: "+Optional.ofNullable(person1)); // optional
        System.out.println("ofNullable: "+Optional.ofNullable(person2)); // optional.empty

        // Optional empty
        Optional<Person> emptyPerson = Optional.empty();
        System.out.println("get empty isPresent : "+emptyPerson.isPresent()); //false

        // Optional get()
        System.out.println("get : "+optionalPerson1.get()); // Person Object

        // Optional ifPresent()
        Optional<Person> optionalPerson3 = Optional.empty();
        Optional<Person> optionalPerson4 = Optional.of(person1);
        optionalPerson3.ifPresent(person -> System.out.println(person));
        optionalPerson4.ifPresent(person -> System.out.println("ifPresent : "+person));

        // Optional isPresent()
        System.out.println("Optional isPresent() : " +Optional.of(person1).isPresent()); // true
        System.out.println("Optional isPresent() : " +optionalPerson3.isPresent()); // false
        System.out.println("Optional isPresent() : " +Optional.ofNullable(null).isPresent()); // false
//        System.out.println("Optional isPresent() : " +Optional.of(null).isPresent()); // NullPointerException

/**
 * orElse() 메서드는 기본값을 반환하기 위해 매개변수로 전달된 값이 항상 생성됩니다.
 * 이에 비해 orElseGet() 메서드는 매개변수로 전달된
 * Supplier 함수형 인터페이스는 Optional 객체가 값이 없을 때만 호출되며,
 * 기본값 생성 비용이 없는 경우 orElseGet() 메서드를 사용하는 것이 더 효율적입니다.
 */
        // Optional orElse(other: T)
        Person ifNullDefault = Optional.ofNullable(person2).orElse(new Person("ifNullDefault", 222));
        System.out.println("Optional orElse(other: T) : " + ifNullDefault);

        // Optional orElseGet (supplier: Supplier<? extends T>):
        Person elseGet = (Person) Optional.ofNullable(null).orElseGet(() -> new Person("elseGet", 23));
        System.out.println("orElseGet : "+ elseGet);
        // Optional orElseThrow<X extends Throwable>(exceptionSupplier: Supplier<X>):
        try {
            Optional.ofNullable(null).orElseThrow(() -> new NoSuchElementException("No value present"));
        } catch (Exception e) {
            System.out.println(e.getClass());
        }

        // Optional filter()
        Optional<String> message = Optional.of("Hello, World!");
        Optional<String> filteredMessage = message.filter(s -> s.length() > 10);
        if (filteredMessage.isPresent()) {
            System.out.println("Optional filter : "+filteredMessage.get()); // 출력 결과: "Hello, World!"
        } else {
            System.out.println("No message found!");
        }


        // Optional Equals
        Optional<String> message1 = Optional.of("Hello, World!");
        Optional<String> message2 = Optional.of("Hello, World!");
        System.out.println("optional equals : "+message1.equals(message2));     // true
        System.out.println("optional equals : "+message1.equals(Optional.of("Hello"))); // false

        /**
         * map() 메서드를 사용하여 Optional 객체를 변환하는 작업은 코드의 가독성을 높이고,
         * NullPointerException을 방지하는 데 유용합니다.
         * 예를 들어, null 값이 들어올 수 있는 메서드의 반환값을 처리할 때,
         * map() 메서드를 사용하여 반환값이 null인 경우를 처리하는 것이
         * NullPointerException 예외를 방지하는 데 도움이 됩니다.
         *
         * map() 메서드는 함수를 적용하여 새로운 값을 생성하고,
         * 이를 감싼 Optional 객체를 반환합니다.
         * 이때 새로운 값은 반드시 Optional 객체를 반환할 필요는 없습니다.
         * 따라서 map() 메서드를 호출한 결과로 반환된 Optional 객체가 비어있을 수도 있습니다.
         *
         * 반면에 flatMap() 메서드는 함수를 적용하여 새로운 Optional 객체를 생성하고,
         * 이를 풀어낸 값으로 구성된 Optional 객체를 반환합니다.
         * 즉, 함수가 반환하는 값은 반드시 Optional 객체여야 하며,
         * 이를 풀어낸 결과가 Optional 객체가 됩니다.
         * 따라서 flatMap() 메서드를 호출한 결과로 반환된 Optional 객체는 비어있지 않습니다.
         */
        // optional map
        Optional<String> messageTest = Optional.of("Hello, World!");
        Optional<Integer> length = messageTest.map(str -> str.length());
        System.out.println(length.get()); // 13


        Optional<String> messageFlatMap = Optional.of("Hello, World!");
        Optional<Integer> length2 = messageFlatMap.flatMap(str -> Optional.of(str.length()));
        System.out.println(length2.get()); // 13
    }
}
