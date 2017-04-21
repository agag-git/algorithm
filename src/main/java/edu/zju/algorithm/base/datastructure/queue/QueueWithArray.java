package edu.zju.algorithm.base.datastructure.queue;

public class QueueWithArray<E> implements edu.zju.algorithm.base.datastructure.queue.Queue<E> {
    Object[] arr;
    int size = 0;
    int head = 0;
    int tail = 0;

    public QueueWithArray(int initSize) {
        size = initSize;
        arr = new Object[size];
    }

    public boolean isFull() {
        return (tail + 1) % size == head;
    }

    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        E ele = (E)arr[head];
        head = (head + 1) % size;
        return ele;
    }

    @Override
    public boolean add(E e) {
        if (isFull()) {
            return false;
        }
        arr[tail] = e;
        tail = (tail + 1) % size;
        return true;
    }

}

