package edu.zju.algorithm.base.datastructure.queue;

public interface Queue<E> {
    public boolean isFull();

    public boolean isEmpty();

    public int size();

    public E pop();

    public boolean push(E e);
}
