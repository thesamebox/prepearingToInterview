package ru.geekbrains.prepearingToInterview.lesson2;

public class OwnArrayList<T> implements OwnList<T> {
    private int size = 0;
    private int capacity = 0;
    private final int CAPACITY = 16;
    private Object[] items;

    public OwnArrayList() {
        capacity = CAPACITY;
        items = new Object[capacity];
    }

    public OwnArrayList(int capacity) {
        this.capacity = capacity;
        items = new Object[capacity];
    }
    @Override
    public void add(T t) {
        if (size >= capacity) {
            capacity = capacity * 2;
            Object[] increasedArray = new Object[capacity];
            for (int i = 0; i < size; i++) {
                increasedArray[i] = items[i];
                items[i] = null;
            }
            items = increasedArray;
        }
        items[size++] = t;
        trimSize();
    }

    @Override
    public void remove(T t) {
        if (size == 0) {
            return;
        }
        for (int i = 0; i < size; i++) {
            if (items[i].equals(t)) {
                items[i] = null;
                moveLeft(i);
                trimSize();
                break;
            }
        }
    }


    @Override
    public void remove(int i) {
        if (i < size && i >= 0) {
            items[i] = null;
            moveLeft(i);
            trimSize();
        }
    }

    @Override
    public boolean contains(T t) {
        return indexOf(t) >= 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            items[i] = null;
        }
        size = 0;
    }

    @Override
    public int indexOf(T t) {
        if (t == null) {
            for (int i = 0; i < size; i++) {
                if (items[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (t.equals(items[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public void set(int i, T t) {
        if (i < size && i >= 0) {
            Object o = items[i];
            items[i] = t;
        }
    }

    public T get(int i) {
        if (i < size && i >= 0) {
            return (T) items[i];
        }
        return null;
    }

    private void moveLeft(int start) {
        size--;
        if (size <= 0) {
            return;
        }
        if (size != start) {
            System.arraycopy(items, start + 1, items, start, size - start);
        }
        items[size] = null;
    }

    public void printList() {
        for (Object item : items) {
            System.out.print("/" + item);
        }
        System.out.println("\n");

    }

    private void trimSize() {
        capacity = size;
        Object[] trimArray = new Object[capacity];
        System.arraycopy(items, 0, trimArray, 0, size);
        items = trimArray;
    }
}

