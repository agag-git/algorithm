package edu.zju.algorithm.base.datastructure.queue;

import java.util.Stack;

/**
 * 栈实现队列
 * @param <E>
 */
public class QueueWithStack<E> implements Queue<E> {
    private Stack<E> pushStack = new Stack<>();
    private Stack<E> popStack = new Stack<>();

    public boolean isFull() {
        return pushStack.size() == pushStack.capacity();
    }

    public boolean isEmpty() {
        return popStack.isEmpty() && pushStack.isEmpty();
    }

    @Override
    public int size() {
        return pushStack.size() + popStack.size();
    }

    @Override
    public E pop() {
        if (popStack.isEmpty()) {
            if (!reload()) {
                return null;
            }
        }
        return popStack.pop();
    }

    @Override
    public boolean push(E e) {
        if (isFull()) {
            return false;
        }
        pushStack.push(e);
        return true;
    }

    private boolean reload() {
        if (pushStack.isEmpty()) {
            return false;
        }
        while (!pushStack.isEmpty()) {
            E e = pushStack.pop();
            popStack.push(e);
        }
        return true;
    }

}

