package jutil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

class PersonComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return o1.getAge() - o2.getAge();
    }
}

public class CollectionsTest {
    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> randomIntegerList = new ArrayList<>();
        for(int i=0; i<100;i++){
            randomIntegerList.add(random.nextInt(100) + 1);
        }

        // sort(List<T> list)
        Collections.sort(randomIntegerList);
        System.out.println(randomIntegerList);

        // sort(List<T> list, Comparator<? super T> c)
        List<Person> people = new ArrayList<>();
        people.add(new Person("John", 30));
        people.add(new Person("Alice", 25));
        people.add(new Person("Bob", 35));
        people.add(new Person("Aob", 35));
        people.add(new Person("Bob2", 31));
        people.add(new Person("Bob3", 33));
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                int ageCompare = Integer.compare(p1.getAge(), p2.getAge());
                if(ageCompare !=0){
                    return ageCompare;
                }
                return p1.getName().compareTo(p2.getName());
            }
        });
        for (Person person : people) {
            System.out.println(person.getName() + " (" + person.getAge() + ")");
        }

        // reverse(List<?> list)
        Collections.reverse(randomIntegerList);
        System.out.println(randomIntegerList);

        // binarySearch(List<? extends Comparable<? super T>> list, T key)
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(30);
        numbers.add(30);
        int key = 10;
        int index = Collections.binarySearch(numbers, key);
        if (index >= 0) {
            System.out.println("The key " + key + " is found at index " + index);
        } else {
            System.out.println("The key " + key + " is not found in the list");
        }

        // binarySearch(List<? extends T> list, T key, Comparator<? super T> c)
        int index2 = Collections.binarySearch(people, new Person("Alice", 35), new PersonComparator());
        System.out.println("Index of Alice: " + index2);

        // shuffle(List<?> list)
        Collections.shuffle(randomIntegerList);
        System.out.println(randomIntegerList);

        // copy(List<? super T> dest, List<? extends T> src)
        List<Integer> srcList = new ArrayList<>();
        srcList.add(1);
        srcList.add(2);
        srcList.add(3);
        List<Integer> destList = new ArrayList<>(Collections.nCopies(srcList.size(), null));
        System.out.println("Before copy:");
        System.out.println("Source List: " + srcList);
        System.out.println("Destination List: " + destList);
        Collections.copy(destList, srcList);
        System.out.println("After copy:");
        System.out.println("Source List: " + srcList);
        System.out.println("Destination List: " + destList);

        // fill(List<? super T> list, T obj):
        Collections.fill(randomIntegerList,1);
        System.out.println(randomIntegerList);

        // addAll(Collection<? super T> c, T... elements)
        Collections.addAll(randomIntegerList, 2,3,4);
        System.out.println(randomIntegerList);

        // disjoint(Collection<?> c1, Collection<?> c2)
        boolean src = Collections.disjoint(srcList, destList);
        System.out.println(src);
        destList.remove(0);
        destList.remove(0);
        destList.remove(0);
        destList.add(4);
        destList.add(5);
        destList.add(6);
        boolean dest = Collections.disjoint(srcList, destList);
        System.out.println(dest); // true
    }
}
