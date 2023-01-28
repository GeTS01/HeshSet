import org.w3c.dom.Node;

import java.util.*;

public class HashMapImpl<K, V> implements Map<K, V> {

    private NodeHashMap<K, V>[] table = new NodeHashMap[10];
    private int count = 0;

    /**
     * this method returns the number of elements
     *
     * @return count
     */
    @Override
    public int size() {
        return count;
    }

    /**
     * this method checks the content of the elements in the list
     *
     * @return true if o is removed, else - false
     */
    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * this method checks for the existence of an element by key
     *
     * @param key - transmitted key
     * @return true if o is removed, else - false
     */
    @Override
    public boolean containsKey(Object key) {
        return get(key) != null;
    }

    /**
     * this method checks for the passed value
     *
     * @param value - transmitted value
     * @return - true if o is removed, else - false
     */
    @Override
    public boolean containsValue(Object value) {
        for (NodeHashMap<K, V> node : table) {
            if (node.getValue().equals(value)) {
                return true;
            }
            while (node.getNext() != null) {
                node = node.getNext();
                if (node.getValue().equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * this method returns the value given by the given key
     *
     * @param key transmitted key
     * @return returns the value under the passed key
     */
    @Override
    public V get(Object key) {
        int index = index(key);
        NodeHashMap<K, V> current = table[index];
        if (current == null) {
            return null;
        } else {
            if (key.equals(current.getKey())) {
                return current.getValue();
            }
            while (current.getNext() != null) {
                current = current.getNext();
                if (key.equals(current.getKey())) {
                    return current.getValue();
                }
            }
        }
        return null;
    }


    /**
     * this method adds an element with parameters and a key value at the index,
     * which was converted through the hash method, and if two elements have the same index,
     * then a collision occurs, and resolve it thanks to a single-linked list
     *
     * @param key   - transmitted key
     * @param value - transmitted value
     * @return value
     */
    @Override
    public V put(K key, V value) {
        int index = index(key);
        NodeHashMap<K, V> node = table[index];
        if (node == null) {
            table[index] = new NodeHashMap<>(hash(key), key, value, null);
            count++;
            return value;
        }

        while (node.getNext() != null && !key.equals(node.getNext().getKey())) {
            node = node.getNext();
        }
        if (node.getNext() == null) {
            node.setNext(new NodeHashMap<>(hash(key), key, value, null));
            return value;
        }

        node.setValue(value);
        count++;
        return value;
    }

    /**
     * this method removes the element by the specified key
     *
     * @param key - transmitted key
     * @return remote value
     */
    @Override
    public V remove(Object key) {
        int index = index(key);
        NodeHashMap<K, V> node = table[index];
        if (node == null) {
            return null;
        } else {
            if (key.equals(node.getKey()) && node.getNext() == null) {
                table[index] = null;
            } else {
                while (node.getNext() != null) {
                    if (key.equals(node.getKey())) {
                        node = node.next;
                        break;
                    }
                    node = node.getNext();
                }
            }
        }
        return node.getValue();
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        m.forEach(this::put);
    }

    /**
     * this method removes all elements of the list
     */
    @Override
    public void clear() {
        for (int i = 0; i < table.length - 1; i++) {
            table[i] = null;
            count = 0;
        }
    }

    /**
     * this method will convert the passed key to hashCode
     *
     * @param key - transmitted key
     * @return hashCode
     */
    public int index(Object key) {
        return hash(key) & (table.length - 1);
    }

    static int hash(Object key) {
        int h;
        if (key == null)
            return 0;
        else
            return (h = key.hashCode()) ^ (h >>> 16);
    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    /**
     * this method returns all values
     *
     * @return value
     */
    @Override
    public Collection<V> values() {
        List<V> listValue = new LinkedList<>();
        for (NodeHashMap<K, V> node : table) {
            if (node != null) {
                listValue.add(node.getValue());
                while (node.getNext() != null) {
                    node = node.getNext();
                    listValue.add(node.getValue());
                }
            }
        }
        return listValue;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }

    /**
     * this method returns an array
     *
     * @return nodes
     */
    public Object[] toArray() {
        Node[] nodes = new Node[count];
        for (int i = 0; i < table.length - 1; i++) {
            NodeHashMap<K, V> current = table[i];
            while (current.getNext() != null) {
                nodes[i] = (Node) current;
                current = current.getNext();
            }
        }
        return nodes;
    }

    public boolean retainAll(Collection<?> c) {
        for (int i = 0; i < table.length - 1; i++) {
            NodeHashMap<K, V> current = table[i];
            if (!containsKey(current.getKey())) {
                remove(current.getKey());
            }
            while (current.getNext() != null) {
                current = current.getNext();
                if (!containsKey(current.getKey())) {
                    remove(current.getKey());
                }
            }
        }
        return true;
    }
}