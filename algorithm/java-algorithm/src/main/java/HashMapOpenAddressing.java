class HashMapOpenAddressing {
    private static final int SIZE = 100;
    private Entry[] buckets;

    public HashMapOpenAddressing() {
        buckets = new Entry[SIZE];
    }

    private int hash(int key) {
        return key % SIZE;
    }

    public void insert(int key, String value) {
        int index = hash(key);
        int i = 0;
        while (buckets[index] != null) {
            i++;
            index = linearProbe(index, i);
        }
        buckets[index] = new Entry(key, value);
    }

    public String search(int key) {
        int index = hash(key);
        int i = 0;
        while (buckets[index] != null) {
            Entry entry = buckets[index];
            if (entry.key == key) {
                return entry.value;
            }
            i++;
            index = linearProbe(index, i);
        }
        return null;
    }

    private int linearProbe(int index, int i) {
        return (index + i) % SIZE;
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

class HashMapTest2 {
    public static void main(String[] args) {
        HashMapOpenAddressing hashMap = new HashMapOpenAddressing();

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