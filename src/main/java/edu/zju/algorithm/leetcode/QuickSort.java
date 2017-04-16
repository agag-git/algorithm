import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

/**
 * Created by admin on 2016/5/6.
 */
public class QuickSort {
    public static <T> void ramdomize(T[] array) {
        int ran = (int)(Math.random() * array.length);
        T temp = array[0];
        array[0] = array[ran];
        array[ran] = temp;
    }

    public static <T extends Comparable> void sortRecursively(T[] array, int left, int right) {
        if (left == right)
            return;
        ramdomize(array);
        int current = left;
        for (int i = left + 1; i <= right; i++) {
            if (array[i].compareTo(array[current]) < 0) {
                T temp = array[i];
                array[i] = array[current + 1];
                array[current + 1] = array[current];
                array[current++] = temp;
            }
        }
        if (current > left + 1)
            sortRecursively(array, left, current - 1);
        if (current < right - 1)
            sortRecursively(array, current + 1, right);
    }

    public static <T extends Comparable> void sortWithStack(T[] array) {
        if (array.length <= 1)
            return;
        ramdomize(array);
        Stack<Integer> stack = new Stack();
        stack.push(array.length - 1);
        stack.push(0);
        while (!stack.empty()) {
            int left = stack.pop();
            int right = stack.pop();
            int current = left;
            for (int i = left; i <= right; i++) {
                if (array[i].compareTo(array[current]) < 0) {
                    T temp = array[i];
                    array[i] = array[current + 1];
                    array[current + 1] = array[current];
                    array[current++] = temp;
                }
            }
            if (left < current - 1) {
                stack.push(current - 1);
                stack.push(left);
            }
            if (current < right - 1) {
                stack.push(right);
                stack.push(current + 1);
            }
        }
    }

    public static <T extends Comparable> void sortWithQueue(T[] array) {
        if (array.length <= 1)
            return;
        ramdomize(array);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        queue.offer(array.length - 1);
        while (!queue.isEmpty()) {
            int left = queue.poll();
            int right = queue.poll();
            int current = left;
            for (int i = left; i <= right; i++) {
                if (array[i].compareTo(array[current]) < 0) {
                    T temp = array[i];
                    array[i] = array[current + 1];
                    array[current + 1] = array[current];
                    array[current++] = temp;
                }
            }
            if (current > left + 1) {
                queue.offer(left);
                queue.offer(current - 1);
            }
            if (current < right - 1) {
                queue.offer(current + 1);
                queue.offer(right);
            }
        }
    }

    public static void sortIntInc(int[] array, int left, int right) {
        if (array.length <= 1)
            return;
        int current = left;
        for (int i = left + 1; i <= right; i++) {
            if (array[i] < array[current]){
                int temp = array[i];
                array[i] = array[current + 1];
                array[current + 1] = array[current];
                array[current++] = temp;
            }
        }
        if (current > left + 1)
            sortIntInc(array, left, current - 1);
        if (current < right - 1)
            sortIntInc(array, current + 1, right);
    }

    public static void main(String[] args) {
        Element[] array = {new Element(3), new Element(5), new Element(2), new Element(11),
                new Element(3), new Element(2), new Element(23), new Element(4), new Element(7)};
        sortWithQueue(array);
        for (Element e : array)
            System.out.println(e.getValue());
    }
}

class Element implements Comparable {
    private int value;
    public Element(){
        value = 0;
    }
    public Element(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(Object o) {
        return value - ((Element)o).getValue();
    }
}
