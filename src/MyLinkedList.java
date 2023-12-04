public class MyLinkedList<K, V> {
    private MyNode<K, V> head;

    public void add(K key, V value) {
        MyNode<K, V> newNode = new MyNode<>(key, value);
        newNode.next = head;
        head = newNode;
    }

}
