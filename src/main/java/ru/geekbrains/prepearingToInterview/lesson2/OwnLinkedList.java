package ru.geekbrains.prepearingToInterview.lesson2;

public class OwnLinkedList<T> implements OwnList<T> {
    private int size;
    private Elem<T> first;
    private Elem<T> last;

    private static class Elem<T> {
        T item;
        Elem<T> next;
        Elem<T> prev;

        public Elem(T item) {
            this.item = item;

        }

        public boolean hasNext() {
            return item != null;
        }

    }

    @Override
    public void add(T t) {
        Elem<T> newElem = new Elem<>(t);
        if (first == null) {
            first = newElem;
        } else {
            last.next = newElem;
            newElem.prev = last;
        }
        last = newElem;
        size++;
    }

    @Override
    public void remove(T t) {
        Elem<T> current = first;

        while (current != null) {
            if (current.item.equals(t)) {
                if (current.prev == null) {
                    first = current.next;
                    current.next.prev = null;
                    current = null;
                    size--;
                    break;
                }
                if (current.next == null) {
                    last = current.prev;
                    current.prev.next = null;
                    current = null;
                    size--;
                    break;
                }
                current.next.prev = current.prev;
                current.prev.next = current.next;
                current = null;
                size--;
                break;
            }
            current = current.next;
        }
    }

    @Override
    public void remove(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException();
        }
        Elem<T> current = first;

        if (i == 0) {
            current.next.prev = null;
            first = current.next;
        } else {
            if (i == size - 1) {
                current = last;
                current.prev.next = null;
            } else {
                do {
                    current = current.next;
                    i--;
                } while (i - 1 >= 0);
                current.next.prev = current.prev;
                current.prev.next = current.next;
            }
        }
        current = null;
        size--;

    }

    @Override
    public boolean contains(T t) {
        Elem<T> current = first;
        while (current != null) {
            if (current.item.equals(t)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public int indexOf(T t) {
        int index = 0;
        Elem<T> current = first;

        while (!current.item.equals(t)) {
            index++;
            current = current.next;
        }
        return index;
    }

    @Override
    public void set(int i, T t) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (first == null || i == size - 1) {
            add(t);
        }
        Elem<T> newElem = new Elem<>(t);
        Elem<T> current = first;
        while (i > 0) {
            current = current.next;
            i--;
        }
        newElem.next = current;
        newElem.prev = current.prev;
        current.prev = newElem;
        newElem.prev.next = newElem;
        size++;
    }

    public void printList() {
        Elem<T> current = first;
        if (first == null) {
            System.out.print("null");
            return;
        }

        do {
            System.out.print("/" + current.item);
            current = current.next;
        } while (current != null);

    }
}
