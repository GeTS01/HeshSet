
public class NodeHashMap<K, V> {
    final int hash;
    final K key;
    V value;
    NodeHashMap<K, V> next;

    public NodeHashMap(int hash, K key, V value, NodeHashMap<K, V> next) {
        this.hash = hash;
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public int getHash() {
        return hash;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public NodeHashMap<K, V> getNext() {
        return next;
    }

    public void setNext(NodeHashMap<K, V> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "NodeHashMap{" +
                "hash=" + hash +
                ", key=" + key +
                ", value=" + value +
                ", next=" + next +
                '}';
    }
}
