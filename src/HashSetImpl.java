import java.util.*;

public class HashSetImpl<K> implements Set<K> {
    private final Object object = new Object();
    private final HashMapImpl<K, Object> map = new HashMapImpl<>();

    /**
     * this method returns the number of elements
     *
     * @return count
     */
    @Override
    public int size() {
        return map.size();
    }

    /**
     * this method checks the content of the elements in the Set
     *
     * @return true if o is removed, else - false
     */
    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    /**
     * this method checks if the element is present in the Set
     *
     * @param o - object to check
     * @return true if o is removed, else - false
     */
    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    /**
     * this method iterates over the Set
     *
     * @return true if o is removed, else - false and element
     */
    @Override
    public Iterator<K> iterator() {
        return map.keySet().iterator();
    }

    /**
     * this method returns an array containing all the elements in this Set
     *
     * @return massive
     */
    @Override
    public Object[] toArray() {
        return map.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    /**
     * this method adds the specified element to the end of this Set
     *
     * @param k - element to add
     * @return true if o is removed, else - false
     */
    @Override
    public boolean add(K k) {
        map.put(k, object);
        return true;
    }

    /**
     * this method remove object by reference
     *
     * @param o - object to delete
     * @return true if o is removed, else - false
     */
    @Override
    public boolean remove(Object o) {
        if (o == null) {
            throw new NullPointerException();
        }
        map.remove(o);
        return true;
    }

    /**
     * this method checks if the collection is in the Set
     *
     * @param c - passed collection to check
     * @return true if o is removed, else - false
     */
    @Override
    public boolean containsAll(Collection<?> c) {
        for (var item : c) {
            if (!contains(item)) {
                return false;
            }
        }
        return true;
    }

    /**
     * this method adding a collection to the end of a Set
     *
     * @param c - passed collection to add
     * @return true if o is removed, else - false
     */
    @Override
    public boolean addAll(Collection<? extends K> c) {
        for (var item : c) {
            if (item != null) {
                add(item);
            }
        }
        return true;
    }

    /**
     * this method removes all elements except the passed collection
     *
     * @param c - passed collection to remove
     * @return true if o is removed, else - false
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        return map.retainAll(c);
    }

    /**
     * this method removes the elements of the passed collection
     *
     * @param c passed collection to remove
     * @return true if o is removed, else - false
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        for (var item : c) {
            if (item != null) {
                remove(item);
                return true;
            }
        }
        return false;
    }

    /**
     * this method removes all elements of the Set
     */
    @Override
    public void clear() {
        map.clear();
    }
}
