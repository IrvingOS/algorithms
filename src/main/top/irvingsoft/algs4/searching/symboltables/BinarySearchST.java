package top.irvingsoft.algs4.searching.symboltables;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 二分查找符号表
 * <p>
 * 基于有序数组
 * <p>
 * 自动扩容
 *
 * @author TimeChaser
 * @since 2021/11/29 16:12
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> {

    private Key[] keys;
    private int n;
    private Value[] values;

    public BinarySearchST() {
        this(8);
    }

    public BinarySearchST(int initCapacity) {
        if (initCapacity <= 0) {
            throw new IllegalArgumentException("initCapacity to BinarySearchST() is negative number");
        }
        keys = (Key[]) new Comparable[initCapacity];
        values = (Value[]) new Object[initCapacity];
    }

    public Key ceiling(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("key to ceiling() is null");
        }
        int i = rank(key);
        if (i < n) {
            return keys[i];
        }
        return null;
    }

    public boolean check() {
        for (int i = 0; i < n; i++) {
            if (rank(select(i)) != i || select(rank(keys[i])) != keys[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public void delete(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("key to delete() is null");
        }
        if (isEmpty()) {
            return;
        }
        int i = rank(key);
        if (i < n && key.compareTo(keys[i]) == 0) {
            for (int j = i; j < n - 1; j++) {
                keys[j] = keys[j + 1];
                values[j] = values[j + 1];
            }
            n--;
            if (n == keys.length / 4 - 1) {
                resize(keys.length / 2);
            }
        }
        assert check();
    }

    public Key floor(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("key to floor() is null");
        }
        int i = rank(key);
        if (i < n && key.compareTo(keys[i]) == 0) {
            return keys[i];
        } else {
            return keys[i - 1];
        }
    }

    public Value get(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("key to get() is null");
        }
        if (isEmpty()) {
            return null;
        }
        int i = rank(key);
        if (i < n && key.compareTo(keys[i]) == 0) {
            return values[i];
        } else {
            return null;
        }
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> queue = new ArrayDeque<>();
        for (int i = rank(lo); i < rank(hi); i++) {
            queue.offer(keys[i]);
        }
        if (contains(hi)) {
            queue.offer(keys[rank(hi)]);
        }
        return queue;
    }

    public Key max() {
        if (isEmpty()) {
            return null;
        }
        return keys[n - 1];
    }

    public Key min() {
        if (isEmpty()) {
            return null;
        }
        return keys[0];
    }

    public void put(Key key, Value value) {
        if (key == null) {
            throw new IllegalArgumentException("key to put() is null");
        }
        if (value == null) {
            delete(key);
            return;
        }
        if (n != 0 && key.compareTo(max()) > 0) {
            if (n == keys.length) {
                resize(2 * keys.length);
            }
            keys[n] = key;
            values[n] = value;
            n++;
            return;
        }
        int i = rank(key);
        if (i < n && key.compareTo(keys[i]) == 0) {
            values[i] = value;
            return;
        }
        if (n == keys.length) {
            resize(2 * keys.length);
        }
        for (int j = n; j > i; j--) {
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
        }
        keys[i] = key;
        values[i] = value;
        n++;
        assert check();
    }

    public int rank(Key key) {
        int lo = 0;
        int hi = n - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int compareTo = key.compareTo(keys[mid]);
            if (compareTo < 0) {
                hi = mid - 1;
            } else if (compareTo > 0) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return lo;
    }

    public Key select(int k) {
        if (k < 0 || k >= size()) {
            throw new IllegalArgumentException("k to select() is illegal");
        }
        if (isEmpty()) {
            return null;
        }
        return keys[k];
    }

    public int size() {
        return n;
    }

    private void resize(int capacity) {
        assert capacity > n;
        Key[] tempKeys = (Key[]) new Comparable[capacity];
        Value[] tempValues = (Value[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            tempKeys[i] = keys[i];
            tempValues[i] = values[i];
        }
        this.keys = tempKeys;
        this.values = tempValues;
    }

}
