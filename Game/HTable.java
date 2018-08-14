import java.util.ArrayList;

public class HTable {

    private ArrayList<Pair>[] buckets;
    private int length = 0;
    private static final double LOADFACTOR = .75;

    public HTable() {
        buckets = new ArrayList[16];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<Pair>();
        }
    }

    private void rehash() {
    }

    public void put(String key, Integer value) {
        if ((double) length / buckets.length > LOADFACTOR) {
            rehash();
        }
        buckets[key.hashCode() % buckets.length].add(new Pair(key, value));
        length++;
    }

    public Integer get(String key) {
        for (Pair p : buckets[key.hashCode() % buckets.length]) {
            if (p.key.equals(key)) {
                return p.value;
            }
        }
        return null;
    }

    class Pair {

        String key;
        Integer value;

        public Pair(String k, Integer v) {
            key = k;
            value = v;
        }
    }
}
    class Pair {

        String key;
        Integer value;

        public Pair(String k, Integer v) {
            key = k;
            value = v;
        }
    }