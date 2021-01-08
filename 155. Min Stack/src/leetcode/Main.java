package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.top());    // return 0
        System.out.println(minStack.getMin()); // return -2

    }
}

class MinStack {

    /**
     * initialize your data structure here.
     */
    List<Integer> list;
    private MinValStack<Integer> minValStack;
    int size;

    public MinStack() {
        list = new ArrayList<>();
        size = -1;
        minValStack = new MinValStack<>();
    }

    public void push(int x) {
        list.add(x);
        if (minValStack.isEmpty() || x <= minValStack.peek()) {
            minValStack.push(x);
        }
    }

    public void pop() {
        if (isEmpty()) return;

        if (top() == minValStack.peek()) {
            minValStack.pop();
        }
        int size = list.size();
        list.remove(size - 1);
    }

    public int top() {
        if (isEmpty()) return -1;
        int size = list.size();
        return list.get(size - 1);
    }

    public int getMin() {
        if (isEmpty()) return -1;

        return minValStack.peek();
    }

    private boolean isEmpty() {
        return list.isEmpty();
    }

}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

class MinValStack<E> {
    List<E> list;

    public MinValStack() {
        list = new ArrayList<>();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void push(E val) {
        list.add(val);
    }

    public void pop() {
        int size = list.size();
        list.remove(size - 1);
    }

    public E peek() {
        int size = list.size();
        return list.get(size - 1);

    }
}
