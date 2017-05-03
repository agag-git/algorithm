package edu.zju.algorithm.base.datastructure.Stack;

/**
 * 数组实现栈
 * @param <E>
 */
public class StackWithArray<E> implements Stack<E> {
    private Object[] arr;
    private int top = 0;

    public StackWithArray(int capacity) {
        arr = new Object[capacity];
    }

    @Override
    public boolean isFull() {
        return top == arr.length;
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public int size() {
        return top;
    }

    @Override
    public boolean push(E e) {
        if (isFull()) {
            return false;
        }
        arr[top++] = e;
        return true;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        return (E)arr[--top];
    }
}
