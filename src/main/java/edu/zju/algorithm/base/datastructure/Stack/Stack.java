package edu.zju.algorithm.base.datastructure.Stack;

public interface Stack<E> {
    public boolean isFull();

    public boolean isEmpty();

    public int size();

    public boolean push(E e);

    public E pop();
}
