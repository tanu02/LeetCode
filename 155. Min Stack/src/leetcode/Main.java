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
        System.out.println(minStack.top()); //0

    }
}

class MyStack<T extends Comparable> {
    List<T> list;

    MyStack() {
        list = new LinkedList<>();
    }

    public void push(T item) {
        list.add(item);
    }

    public void pop() {
        list.remove(getSize() - 1);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int getSize() {
        return list.size();
    }

    public T peek() {
        return list.get(getSize() - 1);
    }

}

class MinStack<E extends Comparable> {

    MyStack<E> stack;
    MyStack<E> minStack;

    public MinStack() {
        stack = new MyStack<>();
        minStack = new MyStack<>();
    }

    public void push(E item) {
        stack.push(item);
        if (minStack.isEmpty() || item.compareTo(minStack.peek()) <= 0) {
            minStack.push(item);
        }
    }

    public void pop() {

        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        stack.pop();
    }

    public E top() {
        return stack.peek();
    }

    public E getMin() {
        return minStack.peek();
    }
}

/*

class MinStack<T extends Comparable> {

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

*/
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 *//*


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
*/
//reference https://codereview.stackexchange.com/questions/55386/stack-with-getminimum-operation
