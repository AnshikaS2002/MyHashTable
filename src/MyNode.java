public class MyNode<K, V> {
    K key;
    V value;
    MyNode<K, V> next;

    public MyNode(K key, V value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}
