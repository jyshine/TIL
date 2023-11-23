import java.util.LinkedList;

public class HashMapSeparateChaining2 {
    private static final int SIZE = 10;
    private LinkedList<Entry>[] buckets;

    public HashMapSeparateChaining2() {
        buckets = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    private int hash(int key) {
        return key % SIZE;
    }

    public void insert(int key, String value) {
        int index = hash(key);
        buckets[index].add(new Entry(key, value));
    }

    public String search(int key) {
        int index = hash(key);
        for (Entry entry : buckets[index]) {
            if (entry.key == key) {
                return entry.value;
            }
        }
        return null;
    }

    private static class Entry {
        int key;
        String value;

        Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }
}

class HashMapCollisionTest {
    public static void main(String[] args) {
        HashMapSeparateChaining2 hashMap = new HashMapSeparateChaining2();

        // Insert data to create collision
        hashMap.insert(1, "A");

        // Insert data with intentional collision
        hashMap.insert(11, "B");  // Same hash as key 1
        hashMap.insert(21, "C");  // Same hash as key 1 and 11

        System.out.println("Key 1: " + hashMap.search(1).hashCode());   // Should print "A"
        System.out.println("Key 11: " + hashMap.search(11).hashCode()); // Should print "B"
        System.out.println("Key 21: " + hashMap.search(21).hashCode()); // Should print "C"
        // Search for the inserted data
        System.out.println("Key 1: " + hashMap.search(1));   // Should print "A"
        System.out.println("Key 11: " + hashMap.search(11)); // Should print "B"
        System.out.println("Key 21: " + hashMap.search(21)); // Should print "C"
    }
}
