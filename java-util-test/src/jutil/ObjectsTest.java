package jutil;

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




    }
}
