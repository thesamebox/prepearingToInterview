package ru.geekbrains.prepearingToInterview.lesson2;

interface OwnList<T> {
    void add(T t);

    void remove(T t);

    void remove(int i);

    boolean contains(T t);

    int size();

    void clear();

    int indexOf(T t);

    void set(int i, T t);
}
