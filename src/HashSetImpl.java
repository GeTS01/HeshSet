import java.util.*;

public class HashSetImpl<K, V> implements Set<K> {
    private final Object object = new Object();
    private final HashMapImpl<K, V> map = new HashMapImpl<>();

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);



    }

    @Override
    public Iterator<K> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public Object[] toArray() {
        return Arrays.stream(map.table).toArray();

    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(K k) {
        map.put(k, (V) object);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            throw new NullPointerException("Такого элемента нет");
        }
        map.remove(o);
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (var item : c) {
            if (!contains(item)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends K> c) {
        for (var item : c) {
            if (item != null) {
                add(item);
            }
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        clear();
        return addAll((Collection<? extends K>) c);
    }

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

    @Override
    public void clear() {
        map.clear();
    }
}
