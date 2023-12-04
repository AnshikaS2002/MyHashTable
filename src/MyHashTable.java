import java.util.LinkedList;

public class MyHashTable<K, V> {
    private static final int TABLE_SIZE = 10;
    private LinkedList<MyNode<K, V>>[] table;

    public MyHashTable() {
        table = new LinkedList[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++) {
            table[i] = new LinkedList<>();
        }
    }

    public void add(K key, V value) {
        int index = getHashIndex(key);
        LinkedList<MyNode<K, V>> linkedList = table[index];

        for (MyNode<K, V> node : linkedList) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
        }
        linkedList.add(new MyNode<>(key, value));
    }

    public V get(K key) {
        int index = getHashIndex(key);
        LinkedList<MyNode<K, V>> linkedList = table[index];
        for (MyNode<K, V> node : linkedList) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }
        return null;
    }

    public Iterable<K> keys() {
        LinkedList<K> keys = new LinkedList<>();
        for (LinkedList<MyNode<K, V>> linkedList : table) {
            for (MyNode<K, V> node : linkedList) {
                keys.add(node.key);
            }
        }
        return keys;
    }

    public void remove(K key) {
        int index = getHashIndex(key);
        LinkedList<MyNode<K, V>> linkedList = table[index];

        linkedList.removeIf(node -> areKeysEqual(node.key, key));
    }

    private boolean areKeysEqual(K key1, K key2) {
        if (key1 == null && key2 == null) {
            return true;
        }
        if (key1 == null || key2 == null) {
            return false;
        }
        return key1.toString().equalsIgnoreCase(key2.toString());
    }

    private int getHashIndex(K key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode) % TABLE_SIZE;
    }
}
