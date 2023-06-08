package jutil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class ObjectsTest {
    public static void main(String[] args) {
        // Objects 예제

        // compareTo
        String str1 = "Hello";
        String str2 = "world";
        String str3 = "Hello";
        // Using Objects.compare
        int compareResult1 = Objects.compare(str1, str2, String::compareToIgnoreCase);
        System.out.println("Using Objects.compare:");
        System.out.println("Result: " + compareResult1);
        System.out.println();

        // Using compareTo method
        int compareResult2 = str1.compareToIgnoreCase(str2);
        System.out.println("Using compareTo method:");
        System.out.println("Result: " + compareResult2);
        System.out.println();

        // equals
        // Using equals method to compare two objects
        System.out.println("Using equals method:");
        System.out.println("str1 equals str2? " + str1.equals(str2)); // false
        System.out.println("str1 equals str3? " + str1.equals(str3)); // true

        // deepEquals
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {1, 2, 3};
        int[] arr3 = {4, 5, 6};
        int[][] multiArr1 = {{1, 2, 3}, {4, 5, 6}};
        int[][] multiArr2 = {{1, 2, 3}, {4, 5, 6}};
        int[][] multiArr3 = {{7, 8, 9}, {10, 11, 12}};
        System.out.println("equals? " + Objects.equals(arr1, arr3)); // false

        System.out.println("\nUsing Objects.deepEquals:");
        System.out.println("arr1 equals arr2? " + Objects.deepEquals(arr1, arr2)); // true
        System.out.println("arr1 equals arr3? " + Objects.deepEquals(arr1, arr3)); // false
        System.out.println("multiArr1 equals multiArr2? " + Objects.deepEquals(multiArr1, multiArr2)); // true
        System.out.println("multiArr1 equals multiArr3? " + Objects.deepEquals(multiArr1, multiArr3)); // false

        // isNull, nonNull
        String str4 = "hello";
        String str5 = null;

        System.out.println("\nUsing isNull, nonNull:");
        System.out.println("str4 isNull ? " + Objects.isNull(str4)); // false
        System.out.println("str5 isNull ? " + Objects.isNull(str5)); // true
        System.out.println("str4 nonNull ? " + Objects.nonNull(str4)); // true
        System.out.println("str5 nonNull ? " + Objects.nonNull(str5)); // false


        // hashCode
        Person person1 = new Person("jun1", 30);
        Person person2 = new Person("jun1", 30);
        Person person3 = new Person("jun3", 32);
        System.out.println(person1.hashCode());
        System.out.println(Objects.hashCode(person1));
        System.out.println(person2.hashCode());
        System.out.println(Objects.hashCode(person2));
        System.out.println(person3.hashCode());
        System.out.println(Objects.hashCode(person3));

        // requireNonNull
        String str6 = null;
        String message = "str must be not null";
        try {
            // Objects.requireNonNull(str6, message);
            // 메세지 동적 생성
            Objects.requireNonNull(str6, () -> message + " (value: " + str6 + ")");
        } catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
        // requireNonNullElse
        Person person4 = null;
        Person person5 = new Person("default", 0);
        System.out.println(Objects.requireNonNullElse(person4, person5));
        // requireNonNullElseGet
        Person defaultSupplier = Objects.requireNonNullElseGet(person4, () -> new Person("default supplier ", 1));
        System.out.println(defaultSupplier);

        // isInstanceOf
        System.out.println(person4 instanceof Person);
        System.out.println(person5 instanceof Person);

    }

}
