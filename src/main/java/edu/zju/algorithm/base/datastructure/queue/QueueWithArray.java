package edu.zju.algorithm.base.datastructure.queue;

/**
 * 数组实现队列
 * @param <E>
 */
public class QueueWithArray<E> implements Queue<E> {
    private Object[] arr;
    private int capacity = 0;
    private int head = 0;
    private int tail = 0;

    public QueueWithArray(int initSize) {
        capacity = initSize;
        arr = new Object[capacity];
    }

    public boolean isFull() {
        return (tail + 1) % capacity == head;
    }

    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public int size() {
        return (tail + capacity - head) % capacity;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        E ele = (E)arr[head];
        head = (head + 1) % capacity;
        return ele;
    }

    @Override
    public boolean push(E e) {
        if (isFull()) {
            return false;
        }
        arr[tail] = e;
        tail = (tail + 1) % capacity;
        return true;
    }

}

