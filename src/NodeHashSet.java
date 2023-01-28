
public class NodeHashSet<K> {
    final int hash;
    final K key;
    NodeHashSet<K> nextNodeHashSet;

    public NodeHashSet(int hash, K key) {
        this.hash = hash;
        this.key = key;
    }

    public int getHash() {
        return hash;
    }

    public K getKey() {
        return key;
    }

    public NodeHashSet<K> getNextNode() {
        return nextNodeHashSet;
    }

    public void setNextNode(NodeHashSet<K> nextNodeHashSet) {
        this.nextNodeHashSet = nextNodeHashSet;
    }
}
