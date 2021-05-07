package leetcode;

import java.util.LinkedList;
import java.util.List;

class Main7 {

    public static void main(String[] args) {
        MinStack1 minStack = new MinStack1();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        // System.out.println(minStack.top());    // return 0
        System.out.println(minStack.getMin()); // return -2
        System.out.println(minStack.top()); //0

    }
}

class MyStack1<T extends Comparable> {
    List<T> list;

    MyStack1() {
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

class MinStack1<E extends Comparable> {

    MyStack1<E> stack;
    MyStack1<E> minStack;

    public MinStack1() {
        stack = new MyStack1<>();
        minStack = new MyStack1<>();
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
//reference https://codereview.stackexchange.com/questions/55386/stack-with-getminimum-operation
