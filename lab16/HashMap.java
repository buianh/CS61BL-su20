import java.util.ArrayList;
import java.util.LinkedList;
public class HashMap<K, V> implements Map61BL<K, V> {
    /* TODO: Instance variables here */
    LinkedList<Entry<K,V>>[] Map;
    int capacity;
    int count;
    float max_load_factor = (float) 0.5;

    public HashMap() {
        // TODO: YOUR CODE HERE
        capacity = 16;
        Map = new LinkedList [capacity];
        count = 0;
    }

    public HashMap(int size_capacity) {
        // TODO: YOUR CODE HERE
        capacity = size_capacity;
        Map = new LinkedList[capacity];
        count = 0;
    }

    public HashMap(int size_capacity,float load_factor) {
        // TODO: YOUR CODE HERE
        capacity = size_capacity;
        Map = new LinkedList[capacity];
        count = 0;
        max_load_factor = load_factor;

    }

    /* Returns the number of items contained in this map. */
    public int size() {
        // TODO: YOUR CODE HERE
        /*int count_size = 0;
        for (int i =0;i<capacity; i++){
            for (Entry<K, V> e: Map.get(i)) {
                if (e.key != null) {
                    count_size += 1;
                }
            }
        }
        return count_size;*/
        return count;
    }

    public int capacity(){
        return capacity;
    }

    @Override
    public void clear() {
        for (int i = 0; i < capacity; i++) {
            Map[i]=null;
        }
        count = 0;
    }

    /* Returns true if the map contains the KEY. */
    @Override
    public boolean containsKey(K key) {
        // TODO: YOUR CODE HERE
        int code = Math.floorMod(key.hashCode(),capacity);
        if (code < 0 || Map[code]==null) {
            return false;
        }
        for (Entry<K, V> e: Map[code]) {
            if (e.key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    /* Returns the value for the specified KEY. If KEY is not found, return
       null. */
    @Override
    public V get(K key) {
        // TODO: YOUR CODE HERE
        int code = Math.floorMod(key.hashCode(),capacity);
        for (Entry<K, V> e: Map[code]) {
            if (e.key.equals(key)) {
                return (V) e.value;
            }
        }
        return null;
    }

    /* Puts a (KEY, VALUE) pair into this map. If the KEY already exists in the
       SimpleNameMap, replace the current corresponding value with VALUE. */
    @Override
    public void put(K key, V value) {
        // TODO: YOUR CODE HERE
        int code = Math.floorMod(key.hashCode(),capacity);
        if (containsKey(key)){
            for (Entry<K, V> e: Map[code]){
                if (e.key.equals(key)) {
                    e.value = value;
                }
            }
        } else {
            if (Map[code] != null) {
                if (count<=capacity) {
                    Map[code].add(new Entry(key, value));
                    count += 1;
                } else {
                    resize();
                    int code_new = Math.floorMod(key.hashCode(),capacity);
                    Map[code_new].add(new Entry<K, V>(key, value));
                    count += 1;
                }
            } else {
                LinkedList<Entry<K, V>> Map_tmp = new LinkedList<>();
                Map_tmp.add(new Entry<K, V>(key, value));
                if (count<=capacity) {
                    Map[code] = Map_tmp;
                    count += 1;
                } else {
                    resize();
                    int code_new = Math.floorMod(key.hashCode(),capacity);
                    Map[code_new] = Map_tmp;
                    count += 1;
                }
            }
        }
    }

    /* Removes a single entry, KEY, from this table and return the VALUE if
       successful or NULL otherwise. */
    @Override
    public V remove(K key) {
        // TODO: YOUR CODE HERE
        int code = Math.floorMod(key.hashCode(),capacity);
        for (Entry<K, V> e: Map[code]) {
            if (e.key.equals(key)) {
                V value = e.value;
                Map[code].remove(e);
                count -= 1;
                return value;
            }
        }
        return null;
    }

    @Override
    public boolean remove(K key, V value) {
        // TODO: YOUR CODE HERE
        int code = Math.floorMod(key.hashCode(),capacity);
        for (Entry<K, V> e: Map[code]) {
            if (e.key.equals(key)) {
                Map[code].remove(e);
                count -= 1;
                return true;
            }
        }
        return false;
    }

    void resize() {
        LinkedList<Entry<K, V>>[] Map_new = new LinkedList[capacity*2];
        for (int i =0; i<capacity; i++){
            Map_new[i] = Map[i];
        }
        Map = Map_new;
        capacity *= 2;
    }

    private static class Entry<K, V> {

        private K key;
        private V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        /* Returns true if this key matches with the OTHER's key. */
        public boolean keyEquals(Entry<K, V> other) {
            return key.equals(other.key);
        }

        /* Returns true if both the KEY and the VALUE match. */
        @Override
        public boolean equals(Object other) {
            return (other instanceof Entry
                    && key.equals(((Entry<K, V>) other).key)
                    && value.equals(((Entry<K, V>) other).value));
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }
    }

}
