import java.util.LinkedList;

class HashMapSeparateChaining {
    private static final int SIZE = 100;
    private LinkedList<Entry>[] buckets;

    public HashMapSeparateChaining() {
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

class HashMapTest {
    public static void main(String[] args) {
        HashMapSeparateChaining hashMap = new HashMapSeparateChaining();

        // Random test
        for (int i = 1; i <= 50; i++) {
            hashMap.insert(i, Integer.toString(i));
        }

        for (int i = 1; i <= 50; i++) {
            String result = hashMap.search(i);
            System.out.println("Key: " + i + ", Value: " + result);
        }
    }
}