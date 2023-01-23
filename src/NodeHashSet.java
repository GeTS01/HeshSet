
public class NodeHashSet<V> {
    final int hash;
    final V key;
    NodeHashSet<V> nextNodeHashSet;

    public NodeHashSet(int hash, V key) {
        this.hash = hash;
        this.key = key;
    }

    public int getHash() {
        return hash;
    }

    public V getKey() {
        return key;
    }

    public NodeHashSet<V> getNextNode() {
        return nextNodeHashSet;
    }

    public void setNextNode(NodeHashSet<V> nextNodeHashSet) {
        this.nextNodeHashSet = nextNodeHashSet;
    }
}
